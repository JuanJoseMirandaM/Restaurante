package bo.com.is.evaluation.model;

import bo.com.is.evaluation.model.entity.Restaurante;
import bo.com.is.evaluation.model.entity.TipoComida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoComidaRepository extends CrudRepository<TipoComida, Integer> {
    Iterable<TipoComida> findAll(Sort sort);
    Page<TipoComida> findAll(Pageable pageable);
}
