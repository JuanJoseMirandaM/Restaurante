package bo.com.is.evaluation.controller;

import bo.com.is.evaluation.model.entity.Restaurante;
import bo.com.is.evaluation.service.RestaunteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    @Autowired
    private RestaunteService restaunteService;

    @GetMapping("/all")
    public ResponseEntity<List<Restaurante>> getAll() {
        return new ResponseEntity<>(restaunteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getRestaurante(@PathVariable("id") int idRestaurante){
        return restaunteService.getRestaurante(idRestaurante)
                .map(restaurante -> new ResponseEntity<>(restaurante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/tipoComida/{idTipoComida}")
    public ResponseEntity<List<Restaurante>> getByTipoComida(@PathVariable("idTipoComida") int idTipoComida){
        return restaunteService.getByTipoComida(idTipoComida)
                .map(restaurantes -> new ResponseEntity<>(restaurantes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Restaurante> save(@RequestBody Restaurante restaurante){
        return new ResponseEntity<>(restaunteService.save(restaurante), HttpStatus.CREATED);
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
        if(restaunteService.activate(idRestaurante)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
