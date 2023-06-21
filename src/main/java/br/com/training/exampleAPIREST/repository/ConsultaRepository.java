package br.com.training.exampleAPIREST.repository;

import br.com.training.exampleAPIREST.model.domain.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel,Long> {
}
