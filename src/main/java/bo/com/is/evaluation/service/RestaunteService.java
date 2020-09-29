package bo.com.is.evaluation.service;

import bo.com.is.evaluation.model.RestauranteRepository;
import bo.com.is.evaluation.model.entity.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaunteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> getAll(){
        return restauranteRepository.getAll();
    }

    public Optional<Restaurante> getRestaurante(int restauranteId){
        return restauranteRepository.getRestaurante(restauranteId);
    }

    public Optional<List<Restaurante>> getByTipoComida(int tipoComidaId){
        return restauranteRepository.getByTipoComida(tipoComidaId);
    }

    public Restaurante save(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }

    public boolean activate(int restauranteId){
        return getRestaurante(restauranteId).map(restaurante -> {
            restauranteRepository.activate(restauranteId);
            return true;
        }).orElse(
                false
        );
    }

    public boolean deactivate(int restauranteId){
        return getRestaurante(restauranteId).map(restaurante -> {
            restauranteRepository.deactivate(restauranteId);
            return true;
        }).orElse(
                false
        );
    }
}
