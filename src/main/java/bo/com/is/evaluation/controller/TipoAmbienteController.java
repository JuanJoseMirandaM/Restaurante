package bo.com.is.evaluation.controller;

import bo.com.is.evaluation.dto.TipoAmbienteDto;
import bo.com.is.evaluation.dto.TipoComidaDto;
import bo.com.is.evaluation.model.entity.TipoAmbiente;
import bo.com.is.evaluation.model.entity.TipoComida;
import bo.com.is.evaluation.service.TipoAmbienteService;
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
@RequestMapping("/tipoAmbiente")
public class TipoAmbienteController {
    @Autowired
    private TipoAmbienteService tipoAmbienteService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<TipoAmbienteDto>> getTipoAmbienteList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String sortDir)
    {
        List<TipoAmbiente> tipoAmbientes = tipoAmbienteService.getTipoAmbienteList(page, size, sort, sortDir);
        List<TipoAmbienteDto> tipoAmbientesDto = tipoAmbientes.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(tipoAmbientesDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoAmbienteDto> getTipoAmbiente(@PathVariable("id") int idTipoAmbiente){
        return tipoAmbienteService.getTipoAmbienteById(idTipoAmbiente)
                .map(tipoAmbiente -> new ResponseEntity<>(convertToDto(tipoAmbiente), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<TipoAmbienteDto> save(@Valid @RequestBody TipoAmbienteDto tipoAmbienteDto) throws ParseException {
        TipoAmbiente tipoAmbiente = convertToEntity(tipoAmbienteDto);
        tipoAmbiente.setFechaAlta(LocalDateTime.now());
        tipoAmbiente.setIdUsuarioAlta(1);
        tipoAmbiente.setFechaDesde(LocalDateTime.now());
        tipoAmbiente.setIdUsuarioDesde(1);
        TipoAmbiente postTipoAmbiente = tipoAmbienteService.save(tipoAmbiente);
        return new ResponseEntity<>(convertToDto(postTipoAmbiente), HttpStatus.CREATED);
    }


    private TipoAmbienteDto convertToDto(TipoAmbiente tipoAmbiente) {
        TipoAmbienteDto tipoAmbienteDto = modelMapper.map(tipoAmbiente, TipoAmbienteDto.class);
        return tipoAmbienteDto;
    }

    private TipoAmbiente convertToEntity(TipoAmbienteDto tipoAmbienteDto) throws ParseException {
        TipoAmbiente tipoAmbiente = modelMapper.map(tipoAmbienteDto, TipoAmbiente.class);
        return tipoAmbiente;
    }
}
