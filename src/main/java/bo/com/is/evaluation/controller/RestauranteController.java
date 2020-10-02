package bo.com.is.evaluation.controller;

import bo.com.is.evaluation.dto.RestauranteAmbienteDto;
import bo.com.is.evaluation.dto.RestauranteDto;
import bo.com.is.evaluation.dto.TipoComidaDto;
import bo.com.is.evaluation.model.entity.Restaurante;
import bo.com.is.evaluation.model.entity.RestauranteAmbiente;
import bo.com.is.evaluation.service.RestaunteService;
import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    @Autowired
    private RestaunteService restaunteService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<RestauranteDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String sortDir)
    {
        List<Restaurante> restaurantes = restaunteService.getRestauranteList(page, size, sort, sortDir);
        List<RestauranteDto> restaurantesDto = restaurantes.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(restaurantesDto, HttpStatus.OK);
    }

    @GetMapping("/tipoComida/{idTipoComida}")
    public ResponseEntity<List<RestauranteDto>> getByTipoComida(@PathVariable("idTipoComida") int idTipoComida){
        return restaunteService.getByTipoComida(idTipoComida)
                .map(restaurantes ->{
                    List<RestauranteDto> restaurantesDto = restaurantes.stream().map(this::convertToDto).collect(Collectors.toList());
                    return new ResponseEntity<>(restaurantesDto, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/list")
    public ResponseEntity<List<RestauranteDto>> getByEstado(
            @RequestParam(defaultValue = "activo") String estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String sortDir
    ){
        List<Restaurante> restaurantesByEstado = restaunteService.getByEstado(estado, page, size, sort, sortDir);
        List<RestauranteDto> restaurantesDto = restaurantesByEstado.stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(restaurantesDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDto> getRestaurante(@PathVariable("id") int idRestaurante){
        return restaunteService.getRestaurante(idRestaurante)
                .map(restaurante -> new ResponseEntity<>(convertToDto(restaurante), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<RestauranteDto> save(@Valid @RequestBody RestauranteDto restauranteDto) throws ParseException {
        Restaurante restaurante = convertToEntity(restauranteDto);
        restaurante.getRestauranteAmbientes().forEach(tipoAmbiente -> {
            tipoAmbiente.setRestaurante(restaurante);
            tipoAmbiente.setIdRestaurante(restaurante.getId());
            tipoAmbiente.setFechaAlta(LocalDateTime.now());
            tipoAmbiente.setIdUsuarioAlta(1);
            tipoAmbiente.setFechaDesde(LocalDateTime.now());
            tipoAmbiente.setIdUsuarioDesde(1);
        });
        restaurante.setFechaAlta(LocalDateTime.now());
        restaurante.setIdUsuarioAlta(1);
        restaurante.setFechaDesde(LocalDateTime.now());
        restaurante.setIdUsuarioDesde(1);
        Restaurante postRestaurante = restaunteService.save(restaurante);
        return new ResponseEntity<>(convertToDto(postRestaurante), HttpStatus.CREATED);
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity activate(@PathVariable("id") int idRestaurante){
        if(restaunteService.activate(idRestaurante)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity deactivate(@PathVariable("id") int idRestaurante){
        if(restaunteService.deactivate(idRestaurante)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    @ResponseBody
    public long countEntities() {
        long count = restaunteService.count();
        return count;
    }

    private RestauranteDto convertToDto(Restaurante restaurante) {
        RestauranteDto restauranteDto = modelMapper.map(restaurante, RestauranteDto.class);
        restauranteDto.setTipoComida(restaurante.getTipoComida()!=null?
                modelMapper.map(restaurante.getTipoComida(), TipoComidaDto.class):
                null);
        List<RestauranteAmbienteDto> dtos = restaurante.getRestauranteAmbientes()!=null?
                restaurante.getRestauranteAmbientes()
                        .stream()
                        .map(restauranteAmbiente -> modelMapper.map(restauranteAmbiente, RestauranteAmbienteDto.class))
                        .collect(Collectors.toList()):
                null;
        restauranteDto.setRestauranteAmbientes(dtos);
        return restauranteDto;
    }

    private Restaurante convertToEntity(RestauranteDto restauranteDto) throws ParseException {
        Restaurante restaurante = modelMapper.map(restauranteDto, Restaurante.class);
        List<RestauranteAmbiente> entitys = restauranteDto.getRestauranteAmbientes()!=null?
                restauranteDto.getRestauranteAmbientes()
                .stream()
                .map(restauranteAmbienteDto -> modelMapper.map(restauranteAmbienteDto, RestauranteAmbiente.class))
                .collect(Collectors.toList()) :
                null;
        restaurante.setRestauranteAmbientes(entitys);
        return restaurante;
    }
}
