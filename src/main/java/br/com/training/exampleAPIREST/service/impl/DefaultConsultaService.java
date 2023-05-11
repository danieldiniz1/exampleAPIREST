package br.com.training.exampleAPIREST.service.impl;

import br.com.training.exampleAPIREST.repository.ConsultaRepository;
import br.com.training.exampleAPIREST.service.ConsultaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultConsultaService implements ConsultaService {

    private ConsultaRepository consultaRepository;
}
