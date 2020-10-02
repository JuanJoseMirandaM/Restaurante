package bo.com.is.evaluation.model;

import bo.com.is.evaluation.model.crud.RestauranteCrudRepository;
import bo.com.is.evaluation.model.entity.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RestauranteRepository{
    @Autowired
    private RestauranteCrudRepository restauranteCrudRepository;

    public List<Restaurante> getAllRestaurantes(Integer page, Integer size, String sort, String sortDir) {
        Pageable paging = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        Page<Restaurante> pagedResult = restauranteCrudRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Restaurante>();
        }
    }

    public Optional<List<Restaurante>> getByTipoComida(int idTipoComida) {
        return restauranteCrudRepository.findByIdTipoComida(idTipoComida);
    }

    public List<Restaurante> getByEstado(String estado, Integer page, Integer size, String sort, String sortDir) {
        Pageable paging = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        Page<Restaurante> pagedResult = restauranteCrudRepository.findByEstado(estado, paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Restaurante>();
        }
    }

    public Optional<Restaurante> getRestaurante(int id){
        return restauranteCrudRepository.findById(id);
    }

    public Restaurante save(Restaurante restaurante){
        return restauranteCrudRepository.save(restaurante);
    }

    public void activate(int id){
        Restaurante restaurante = restauranteCrudRepository.findById(id).get();
        restaurante.setEstado("activo");
        restauranteCrudRepository.save(restaurante);
    }

    public void deactivate(int id){
        Restaurante restaurante = restauranteCrudRepository.findById(id).get();
        restaurante.setEstado("inactivo");
        restauranteCrudRepository.save(restaurante);
    }

    public Optional<Restaurante> getData(String field, Object value)
    {
       switch (field)
       {
           case "id":
               return restauranteCrudRepository.findById((Integer)value);
           case "nombre":
               return restauranteCrudRepository.findByNombre((String)value);
           case "telefono":
               return restauranteCrudRepository.findByTelefono((Integer)value);
           default:
               return null;
       }
    }

    public long count() {
        return restauranteCrudRepository.count();
    }

}
