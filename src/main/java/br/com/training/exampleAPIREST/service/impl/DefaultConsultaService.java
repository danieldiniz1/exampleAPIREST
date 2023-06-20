package br.com.training.exampleAPIREST.service.impl;

import br.com.training.exampleAPIREST.model.domain.ConsultaModel;
import br.com.training.exampleAPIREST.repository.ConsultaRepository;
import br.com.training.exampleAPIREST.service.ConsultaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class DefaultConsultaService implements ConsultaService {

    private ConsultaRepository consultaRepository;


    @Override
    public String salvarConsulta(ConsultaModel consulta) {
        ConsultaModel save = consultaRepository.save(consulta);
        return save.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
