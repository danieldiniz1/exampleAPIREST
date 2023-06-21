package br.com.training.exampleAPIREST.service;

import br.com.training.exampleAPIREST.model.domain.PacienteModel;

public interface PacienteService {
    PacienteModel buscarPaciente(String idPaciente);
}
