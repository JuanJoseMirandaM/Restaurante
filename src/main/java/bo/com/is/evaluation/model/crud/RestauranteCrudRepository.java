package bo.com.is.evaluation.model.crud;

import bo.com.is.evaluation.model.entity.Restaurante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestauranteCrudRepository extends CrudRepository<Restaurante, Integer> {
    Optional<List<Restaurante>> findByIdTipoComida(int idTipoComida);

}
