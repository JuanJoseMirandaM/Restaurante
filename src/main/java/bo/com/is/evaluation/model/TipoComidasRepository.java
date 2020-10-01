package bo.com.is.evaluation.model;

import bo.com.is.evaluation.model.entity.Restaurante;
import bo.com.is.evaluation.model.entity.TipoComida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoComidasRepository extends CrudRepository<TipoComida, Integer> {
    Iterable<Restaurante> findAll(Sort sort);
    Page<Restaurante> findAll(Pageable pageable);
}
