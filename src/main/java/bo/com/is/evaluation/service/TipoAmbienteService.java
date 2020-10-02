package bo.com.is.evaluation.service;

import bo.com.is.evaluation.model.TipoAmbienteRepository;
import bo.com.is.evaluation.model.TipoComidaRepository;
import bo.com.is.evaluation.model.entity.TipoAmbiente;
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
public class TipoAmbienteService {
    @Autowired
    private TipoAmbienteRepository tipoAmbienteRepository;

    public List<TipoAmbiente> getTipoAmbienteList(int page, int size, String sort, String sortDir) {

        Pageable paging = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        Page<TipoAmbiente> pagedResult = tipoAmbienteRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<TipoAmbiente>();
        }
    }

    public Optional<TipoAmbiente> getTipoAmbienteById(int id) {
        return tipoAmbienteRepository.findById(id);
    }

    public TipoAmbiente save(TipoAmbiente tipoAmbiente){
        return tipoAmbienteRepository.save(tipoAmbiente);
    }
}
