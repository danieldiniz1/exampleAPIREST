package br.com.training.exampleAPIREST.config.security.controller;

import br.com.training.exampleAPIREST.model.dto.DadosTokenJWTDTO;
import br.com.training.exampleAPIREST.config.security.service.TokenService;
import br.com.training.exampleAPIREST.model.usuario.LoginRecord;
import br.com.training.exampleAPIREST.model.usuario.UsuarioModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginRecord loginRecord){
        var authenticationToken = new UsernamePasswordAuthenticationToken(loginRecord.login(),loginRecord.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        return ResponseEntity.status(200).body(DadosTokenJWTDTO.valueOf(tokenService.geradorToken((UsuarioModel) authentication.getPrincipal())));
    }
}
