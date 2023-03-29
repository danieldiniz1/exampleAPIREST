package br.com.training.exampleAPIREST.repository;

import br.com.training.exampleAPIREST.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel,String> {
}
