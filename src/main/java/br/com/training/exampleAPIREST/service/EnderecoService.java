package br.com.training.exampleAPIREST.service;


import br.com.training.exampleAPIREST.model.domain.EnderecoModel;
import br.com.training.exampleAPIREST.model.dto.CepDto;
import br.com.training.exampleAPIREST.model.record.EnderecoRecord;

public interface EnderecoService {
    EnderecoModel saveEndereco(EnderecoRecord endereco);

    CepDto buscarEnderecoPorCep(String cep);


}
