package br.com.training.exampleAPIREST.repository;

import br.com.training.exampleAPIREST.model.usuario.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    UserDetails findByLogin(String login);
}
