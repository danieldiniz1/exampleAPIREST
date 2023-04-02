package br.com.training.exampleAPIREST.config.security.controller;

import br.com.training.exampleAPIREST.model.usuario.LoginRecord;
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

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginRecord loginRecord){
        var token = new UsernamePasswordAuthenticationToken(loginRecord.login(),loginRecord.password());
        var authentication = authenticationManager.authenticate(token);
        return ResponseEntity.status(200).body("Bearer AYIUSDGFOAYSIDGAS16ASFDAS5641654");
    }
}
