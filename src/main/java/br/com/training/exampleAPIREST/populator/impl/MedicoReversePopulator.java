package br.com.training.exampleAPIREST.populator.impl;

import br.com.training.exampleAPIREST.exception.ConversionPopulatorException;
import br.com.training.exampleAPIREST.model.DadosPessoaisModel;
import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.model.dto.MedicoDTO;
import br.com.training.exampleAPIREST.model.enums.EspecialidadeEnum;
import br.com.training.exampleAPIREST.model.record.MedicoRecord;
import br.com.training.exampleAPIREST.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class MedicoReversePopulator implements Populator<MedicoModel,MedicoDTO> {

    @Override
    public void populate(MedicoModel medicomodel, MedicoDTO medicoDTO) {
        validate(medicomodel,medicoDTO);
        medicoDTO.setId(medicomodel.getUuid());
        medicoDTO.setNome(medicomodel.getDadosPessoais().getNome());
        medicoDTO.setSobrenome(medicomodel.getDadosPessoais().getSobrenome());
        medicoDTO.setEmail(medicomodel.getDadosPessoais().getEmail());
        medicoDTO.setCrm(medicomodel.getCrm());
        medicoDTO.setEspecialidade(medicomodel.getEspecialidade().toString());
    }

    private void validate(MedicoModel medicomodel, MedicoDTO medicoDTO) {
        if (medicomodel == null | medicoDTO == null){
            throw new ConversionPopulatorException("Conversion fail because the params is invalid");
        }
    }
}
