package br.com.training.exampleAPIREST.service.impl;

import br.com.training.exampleAPIREST.model.EnderecoModel;
import br.com.training.exampleAPIREST.model.MedicoModel;
import br.com.training.exampleAPIREST.model.dto.CepDto;
import br.com.training.exampleAPIREST.model.record.EnderecoRecord;
import br.com.training.exampleAPIREST.populator.Populator;
import br.com.training.exampleAPIREST.repository.EnderecoRepository;
import br.com.training.exampleAPIREST.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DefaultEnderecoService implements EnderecoService {

    private static final Logger LOGGER = LogManager.getLogger();
    private WebClient client;
    private EnderecoRepository enderecoRepository;
    private Populator<EnderecoRecord,EnderecoModel> enderecoPopulator;

    @Override
    public EnderecoModel saveEndereco(EnderecoRecord record) {
        EnderecoModel model = EnderecoModel.valueOf();
        enderecoPopulator.populate(record,model);
        return enderecoRepository.save(model);
    }

    @Override
    public CepDto buscarEnderecoPorCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder url = new StringBuilder("https://viacep.com.br/ws/");
        url.append(cep).append("/json/").toString();
        try {
            ResponseEntity<CepDto> forEntity = restTemplate.getForEntity(url.toString(), CepDto.class);
            LOGGER.info("Rest Template: " + forEntity.getBody().toString());


            Mono<CepDto> cepDtoMono = client.get()
                    .uri(uriBuilder -> uriBuilder.path("{cep}/json").build(cep))
                    .exchangeToMono(e -> e.bodyToMono(CepDto.class));
            LOGGER.info("Web client reativo: " + cepDtoMono.block());
            return cepDtoMono.blockOptional().orElseThrow(() -> new RuntimeException());
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
