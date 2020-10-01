package bo.com.is.evaluation.controller;

import bo.com.is.evaluation.dto.RestauranteDto;
import bo.com.is.evaluation.model.entity.Restaurante;
import bo.com.is.evaluation.service.RestaunteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/all")
    public ResponseEntity<List<RestauranteDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort)
    {
        List<Restaurante> restaurantes = restaunteService.getAllRetaurantes(page, size, sort);
        List<RestauranteDto> restaurantesDto = restaurantes.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(restaurantesDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDto> getRestaurante(@PathVariable("id") int idRestaurante){
        return restaunteService.getRestaurante(idRestaurante)
                .map(restaurante -> new ResponseEntity<>(convertToDto(restaurante), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<RestauranteDto>> getByEstado(@PathVariable("estado") String estado){
        return restaunteService.getByEstado(estado)
                .map(restaurantes ->{
                    List<RestauranteDto> restaurantesDto = restaurantes.stream().map(this::convertToDto).collect(Collectors.toList());
                    return new ResponseEntity<>(restaurantesDto, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<RestauranteDto> save(@Valid @RequestBody RestauranteDto restauranteDto) throws ParseException {
        Restaurante restaurante = convertToEntity(restauranteDto);
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


    private RestauranteDto convertToDto(Restaurante restaurante) {
        RestauranteDto restauranteDto = modelMapper.map(restaurante, RestauranteDto.class);
        return restauranteDto;
    }

    private Restaurante convertToEntity(RestauranteDto restauranteDto) throws ParseException {
        Restaurante restaurante = modelMapper.map(restauranteDto, Restaurante.class);
        return restaurante;
    }
}
