package br.com.training.exampleAPIREST.service.impl;

import br.com.training.exampleAPIREST.exception.ModelNotFoundException;
import br.com.training.exampleAPIREST.model.domain.PacienteModel;
import br.com.training.exampleAPIREST.repository.PacienteRepository;
import br.com.training.exampleAPIREST.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultPacienteService implements PacienteService{

    private PacienteRepository repository;
    @Override
    public PacienteModel buscarPaciente(String idPaciente) {
        return repository
                .findById(Long.valueOf(idPaciente))
                .orElseThrow(() -> new ModelNotFoundException("Paciente not found"));
    }
}
