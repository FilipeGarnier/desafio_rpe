package br.com.rpe.Desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpe.Desafio.domain.UserRequest;
import br.com.rpe.Desafio.model.User;
import br.com.rpe.Desafio.repository.UserRepository;

@RequestMapping("api/user")
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public ResponseEntity<User> newUser(@RequestBody UserRequest request){
		
		User userDto = new User();
		
		userDto.setUsername(request.getUserName());
		userDto.setPassword(passwordEncoder.encode(request.getPassword()));
		userDto.setEnabled(true);
		
		User user = userRepo.save(userDto);
		
		user.setPassword("");
		
		return new ResponseEntity<>(user, HttpStatus.OK);			
	}

}
