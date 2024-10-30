package com.dua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dua.dtos.UserCadastroDto;
import com.dua.service.UserService;

@RestController
@RequestMapping("/autenticacao")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserCadastroDto userCadastroDto) {
		userService.registerUser(userCadastroDto);
		return ResponseEntity.ok("Usuário cadastrado com sucesso!");
	}

	@GetMapping("/login")
    public ResponseEntity<String> login(Authentication authentication) {
        // Verifica se a autenticação foi bem-sucedida
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok("Login bem-sucedido!");
        }
        return ResponseEntity.status(401).body("Usuário não autenticado.");
    }

    @GetMapping("/user")
    public ResponseEntity<String> user(Authentication authentication) {
        // Lógica de painel do usuário
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok("Bem-vindo ao painel do usuário, " + authentication.getName() + "!");
        }
        return ResponseEntity.status(403).body("Acesso negado.");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin(Authentication authentication) {
        // Lógica de painel do administrador
        if (authentication != null && authentication.isAuthenticated() && 
            authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok("Bem-vindo ao painel do administrador, " + authentication.getName() + "!");
        }
        return ResponseEntity.status(403).body("Acesso negado.");
    }


}
