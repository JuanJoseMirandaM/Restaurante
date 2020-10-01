package bo.com.is.evaluation.model;

import bo.com.is.evaluation.model.entity.TipoAmbiente;
import bo.com.is.evaluation.model.entity.TipoComida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAmbienteRepository extends CrudRepository<TipoAmbiente, Integer> {
    Iterable<TipoAmbiente> findAll(Sort sort);
    Page<TipoAmbiente> findAll(Pageable pageable);
}
