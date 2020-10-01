package bo.com.is.evaluation.service;

import bo.com.is.evaluation.model.TipoComidaRepository;
import bo.com.is.evaluation.model.entity.Restaurante;
import bo.com.is.evaluation.model.entity.TipoComida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoComidaService {
    @Autowired
    private TipoComidaRepository tipoComidaRepository;

    public List<TipoComida> getTipoComidaList(int page, int size, String sort) {

        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Page<TipoComida> pagedResult = tipoComidaRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<TipoComida>();
        }
    }

    public Optional<TipoComida> getTipoComidaById(int id) {
        return tipoComidaRepository.findById(id);
    }

    public TipoComida save(TipoComida tipoComida){
        return tipoComidaRepository.save(tipoComida);
    }
}
