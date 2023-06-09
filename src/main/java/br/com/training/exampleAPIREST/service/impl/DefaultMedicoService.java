package br.com.training.exampleAPIREST.service.impl;

import br.com.training.exampleAPIREST.exception.ModelNotFoundException;
import br.com.training.exampleAPIREST.model.domain.MedicoModel;
import br.com.training.exampleAPIREST.repository.MedicoRepository;
import br.com.training.exampleAPIREST.service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class DefaultMedicoService implements MedicoService {

    private MedicoRepository medicoRepository;

    @Override
    public String saveMedico(MedicoModel medicoModel) {
        return medicoRepository.save(medicoModel).getUuid();
    }

    @Override
    public boolean buscarMedicoPorCrm(String crm) {
        return medicoRepository.findByCrm(crm).isPresent();
    }

    @Override
    public Page<MedicoModel> findAllMedicos(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return medicoRepository.findAll(PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy));
    }

    @Override
    public MedicoModel findMedicoById(String id) {
        return medicoRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("não foi encontrado médico com id: " + id));
    }

    @Override
    public Page<MedicoModel> findAllMedicosAtivos(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return medicoRepository.findAllByEstaAtivoTrue(PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy));
    }

    @Override
    public MedicoModel buscarMedicoDisponivel() {
        List<MedicoModel> listaMedicosDisponiveis = medicoRepository.findAllByEstaAtivo(Boolean.TRUE);
        Random random = new Random();
        var index = random.nextInt(listaMedicosDisponiveis.size());
        return listaMedicosDisponiveis.get(index);
    }
}
