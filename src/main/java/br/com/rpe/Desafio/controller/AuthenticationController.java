package br.com.rpe.Desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpe.Desafio.domain.LoginRequest;
import br.com.rpe.Desafio.domain.LoginResponse;
import br.com.rpe.Desafio.model.User;
import br.com.rpe.Desafio.service.AuthenticationService;
import br.com.rpe.Desafio.service.JwtService;

@RequestMapping("api/auth")
@RestController
public class AuthenticationController {
	
	@Autowired
	private JwtService jwtService;
    
	@Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request) {
    	
        User authenticatedUser = authenticationService.authenticate(request);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
