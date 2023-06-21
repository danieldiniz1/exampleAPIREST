package br.com.training.exampleAPIREST.facade.impl;

import br.com.training.exampleAPIREST.facade.ConsultaFacade;
import br.com.training.exampleAPIREST.model.domain.ConsultaModel;
import br.com.training.exampleAPIREST.model.domain.MedicoModel;
import br.com.training.exampleAPIREST.model.dto.ConsultaDTO;
import br.com.training.exampleAPIREST.model.record.ConsultaRecord;
import br.com.training.exampleAPIREST.service.ConsultaService;
import br.com.training.exampleAPIREST.service.MedicoService;
import br.com.training.exampleAPIREST.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class DefaultConsultaFacade implements ConsultaFacade {

    private ConsultaService consultaService;
    private PacienteService pacienteService;
    private MedicoService medicoService;

    @Transactional
    @Override
    public ConsultaDTO agendarConsulta(ConsultaRecord dadosConsulta) {
        var paciente = pacienteService.buscarPaciente(dadosConsulta.idPaciente());
        var medico = escolherMedico(dadosConsulta.idMedico());
        var consulta = ConsultaModel.valueOf(medico,paciente,dadosConsulta.data());
        return ConsultaDTO.valueOf(consultaService.salvarConsulta(consulta));
    }

    private MedicoModel escolherMedico(String idMedico) {
        if (idMedico.isEmpty())
            return medicoService.buscarMedicoDisponivel();
        return medicoService.findMedicoById(idMedico);
    }
}
