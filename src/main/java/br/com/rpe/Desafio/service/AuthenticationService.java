package br.com.rpe.Desafio.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import br.com.rpe.Desafio.domain.LoginRequest;
import br.com.rpe.Desafio.model.User;
import br.com.rpe.Desafio.repository.UserRepository;

@Service
public class AuthenticationService {
	
	private final UserRepository userRepository;
	   
	 private final AuthenticationManager authenticationManager;

	    public AuthenticationService(
	        UserRepository userRepository,
	        AuthenticationManager authenticationManager
	    ) {
	        this.authenticationManager = authenticationManager;
	        this.userRepository = userRepository;
	    }

	    public User authenticate(LoginRequest input) {
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        input.getUser(),
	                        input.getPassword()
	                )
	        );

	        return userRepository.getUserByUsername(input.getUser())
	                .orElseThrow();
	    }

}
