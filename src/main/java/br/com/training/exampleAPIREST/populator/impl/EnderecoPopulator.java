package br.com.training.exampleAPIREST.populator.impl;

import br.com.training.exampleAPIREST.exception.ConversionPopulatorException;
import br.com.training.exampleAPIREST.model.EnderecoModel;
import br.com.training.exampleAPIREST.model.record.EnderecoRecord;
import br.com.training.exampleAPIREST.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class EnderecoPopulator implements Populator<EnderecoRecord, EnderecoModel> {
    @Override
    public void populate(EnderecoRecord record, EnderecoModel model) {
        validate(record,model);
        model.setLogradouro(record.logradouro());
        model.setNumero(record.numero());
        model.setComplemento(record.complemento());
        model.setBairro(record.bairro());
        model.setCidade(record.cidade());
        model.setEstado(record.uf());
        model.setCep(record.cep());
        model.setIsActive(record.atual());
    }

    private void validate(EnderecoRecord record, EnderecoModel model) {
        if (record == null | model == null)
            throw new ConversionPopulatorException("Conversion fail because the params is invalid");
    }
}
