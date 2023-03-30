package br.com.training.exampleAPIREST.service.impl;

import br.com.training.exampleAPIREST.model.EnderecoModel;
import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.model.record.EnderecoRecord;
import br.com.training.exampleAPIREST.populator.Populator;
import br.com.training.exampleAPIREST.repository.EnderecoRepository;
import br.com.training.exampleAPIREST.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultEnderecoService implements EnderecoService {

    private EnderecoRepository enderecoRepository;
    private Populator<EnderecoRecord,EnderecoModel> enderecoPopulator;

    @Override
    public EnderecoModel saveEndereco(EnderecoRecord record) {
        EnderecoModel model = EnderecoModel.valueOf();
        enderecoPopulator.populate(record,model);
        return enderecoRepository.save(model);
    }


}
