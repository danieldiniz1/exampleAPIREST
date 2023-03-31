package br.com.training.exampleAPIREST.service.impl;

import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.repository.MedicoRepository;
import br.com.training.exampleAPIREST.service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultMedicoService implements MedicoService {

    private MedicoRepository medicoRepository;

    @Override
    public String saveMedico(MedicoModel model) {
        return medicoRepository.save(model).getUuid();
    }

    @Override
    public boolean buscarMedicoPorCrm(String crm) {
        return medicoRepository.findByCrm(crm).isPresent();
    }

    @Override
    public Page<MedicoModel> findAllMedicos(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return medicoRepository.findAll(PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy));
    }
}
