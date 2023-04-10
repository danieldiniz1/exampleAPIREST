package br.com.training.exampleAPIREST.model.usuario;

import br.com.training.exampleAPIREST.model.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Entity
@Table(name = "TB_ROLE")
@Data
public class RolesModel implements GrantedAuthority {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private RoleEnum roleEnum;


    @Override
    public String getAuthority() {
        return roleEnum.toString();
    }
}
