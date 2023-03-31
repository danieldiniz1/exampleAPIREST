package br.com.training.exampleAPIREST.populator.impl;

import br.com.training.exampleAPIREST.exception.ConversionPopulatorException;
import br.com.training.exampleAPIREST.model.DadosPessoaisModel;
import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.model.record.MedicoUpdateRecord;
import br.com.training.exampleAPIREST.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class MedicoUpdatePopulator implements Populator<MedicoUpdateRecord,MedicoModel> {

    @Override
    public void populate(MedicoUpdateRecord medicoRecord, MedicoModel medicoModel) {
        validate(medicoRecord,medicoModel);
        medicoModel.setDadosPessoais(populateDadosPessoais(medicoRecord,medicoModel));
    }

    private DadosPessoaisModel populateDadosPessoais(MedicoUpdateRecord medicoRecord,MedicoModel medicoModel) {
        DadosPessoaisModel model = DadosPessoaisModel.valueOf();
        model.setNome(medicoRecord.nome().isBlank() ? medicoModel.getDadosPessoais().getNome() : medicoRecord.nome());
        model.setSobrenome(medicoRecord.sobrenome().isBlank() ? medicoModel.getDadosPessoais().getSobrenome(): medicoRecord.sobrenome());
        model.setEmail(medicoRecord.email().isBlank() ? medicoModel.getDadosPessoais().getEmail() : medicoRecord.email());
        model.setTelefone(medicoRecord.telefone().isBlank() ? medicoModel.getDadosPessoais().getTelefone() : medicoRecord.telefone());
        return model;
    }

    private void validate(MedicoUpdateRecord medicoRecord, MedicoModel medicoModel) {
        if (medicoRecord == null | medicoModel == null){
            throw new ConversionPopulatorException("Conversion fail because the params is invalid");
        }
    }
}
