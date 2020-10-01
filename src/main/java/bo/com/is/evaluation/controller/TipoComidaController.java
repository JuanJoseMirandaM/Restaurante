package bo.com.is.evaluation.controller;

import bo.com.is.evaluation.dto.TipoComidaDto;
import bo.com.is.evaluation.model.entity.TipoComida;
import bo.com.is.evaluation.service.TipoComidaService;
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
@RequestMapping("/tipoComida")
public class TipoComidaController {
    @Autowired
    private TipoComidaService tipoComidaService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<TipoComidaDto>> getTipoComidaList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort)
    {
        List<TipoComida> tipoComidas = tipoComidaService.getTipoComidaList(page, size, sort);
        List<TipoComidaDto> tipoComidasDto = tipoComidas.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(tipoComidasDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoComidaDto> getTipoComida(@PathVariable("id") int idTipoComida){
        return tipoComidaService.getTipoComidaById(idTipoComida)
                .map(tipoComida -> new ResponseEntity<>(convertToDto(tipoComida), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<TipoComidaDto> save(@Valid @RequestBody TipoComidaDto tipoComidaDto) throws ParseException {
        TipoComida tipoComida = convertToEntity(tipoComidaDto);
        tipoComida.setFechaAlta(LocalDateTime.now());
        tipoComida.setIdUsuarioAlta(1);
        tipoComida.setFechaDesde(LocalDateTime.now());
        tipoComida.setIdUsuarioDesde(1);
        TipoComida postTipoComida = tipoComidaService.save(tipoComida);
        return new ResponseEntity<>(convertToDto(postTipoComida), HttpStatus.CREATED);
    }


    private TipoComidaDto convertToDto(TipoComida tipoComida) {
        TipoComidaDto tipoComidaDto = modelMapper.map(tipoComida, TipoComidaDto.class);
        return tipoComidaDto;
    }

    private TipoComida convertToEntity(TipoComidaDto tipoComidaDto) throws ParseException {
        TipoComida tipoComida = modelMapper.map(tipoComidaDto, TipoComida.class);
        return tipoComida;
    }
}
