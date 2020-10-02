package bo.com.is.evaluation.model.crud;

import bo.com.is.evaluation.model.entity.Restaurante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteCrudRepository extends CrudRepository<Restaurante, Integer> {
    Iterable<Restaurante> findAll(Sort sort);
    Page<Restaurante> findAll(Pageable pageable);

    Page<Restaurante> findByEstado(String estado,Pageable pageable);

    Optional<List<Restaurante>> findByIdTipoComida(int idTipoComida);
    Optional<List<Restaurante>> findByEstado(String estado);

    Optional<Restaurante> findByNombre(String nombre);
    Optional<Restaurante> findByTelefono(int telefono);
}
