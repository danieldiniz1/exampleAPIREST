package br.com.training.exampleAPIREST.populator.impl;

import br.com.training.exampleAPIREST.exception.ConversionPopulatorException;
import br.com.training.exampleAPIREST.model.domain.DadosPessoaisModel;
import br.com.training.exampleAPIREST.model.domain.MedicoModel;
import br.com.training.exampleAPIREST.model.enums.EspecialidadeEnum;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import br.com.training.exampleAPIREST.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class MedicoPopulator implements Populator<MedicoRecord, MedicoModel> {

    @Override
    public void populate(MedicoRecord medicoRecord, MedicoModel medicoModel) {
        validate(medicoRecord,medicoModel);
        medicoModel.setCrm(medicoRecord.crm());
        medicoModel.setEspecialidade(EspecialidadeEnum.retornaEspecialidade(medicoRecord.especialidade()));
        medicoModel.setDadosPessoais(populateDadosPessoais(medicoRecord));

    }

    private DadosPessoaisModel populateDadosPessoais(MedicoRecord medicoRecord) {
        DadosPessoaisModel model = DadosPessoaisModel.valueOf();
        model.setNome(medicoRecord.nome());
        model.setSobrenome(medicoRecord.sobrenome());
        model.setEmail(medicoRecord.email());
        model.setTelefone(medicoRecord.telefone());
        return model;
    }

    private void validate(MedicoRecord medicoRecord, MedicoModel medicoModel) {
        if (medicoRecord == null | medicoModel == null){
            throw new ConversionPopulatorException("Conversion fail because the params is invalid");
        }
    }
}
