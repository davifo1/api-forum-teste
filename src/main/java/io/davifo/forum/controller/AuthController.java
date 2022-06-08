package io.davifo.forum.controller;

import io.davifo.forum.config.security.TokenService;
import io.davifo.forum.controller.dto.TokenDTO;
import io.davifo.forum.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDTO> auth(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken dataLogin = form.convert();
        try {
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = tokenService.createToken(authentication);

            return ResponseEntity.ok(new TokenDTO(token,"Bearer"));
        }catch (AuthenticationException e ){
            return ResponseEntity.badRequest().build();
        }


    }

}
