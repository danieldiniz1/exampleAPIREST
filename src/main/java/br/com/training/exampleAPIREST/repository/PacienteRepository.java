package br.com.training.exampleAPIREST.repository;

import br.com.training.exampleAPIREST.model.domain.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel,Long> {
}
