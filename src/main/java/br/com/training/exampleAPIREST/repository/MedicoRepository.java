package br.com.training.exampleAPIREST.repository;

import br.com.training.exampleAPIREST.model.MedicoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel,String> {
    Optional<MedicoModel> findByCrm(String crm);
    Page<MedicoModel> findAllByEstaAtivoTrue(PageRequest of);
}
