package com.dua.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dua.dtos.UserCadastroDto;
import com.dua.entity.Role;
import com.dua.entity.User;
import com.dua.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    // Método para salvar um novo usuário com uma role padrão
    public User saveUser(User user) {
        // Verifica se o nome de usuário já está em uso
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Nome de usuário já está em uso.");
        }

        // Codifica a senha antes de salvar
        user.setSenha(passwordEncoder.encode(user.getSenha()));

        // Define uma role padrão se o usuário não tiver nenhuma
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            Role userRole = new Role();
            userRole.setNome("USER"); // Define "USER" como a role padrão
            user.getRoles().add(userRole);
        }

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        var authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNome()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getSenha(), authorities);
    }
    
    public void registerUser(UserCadastroDto userCadastroDto) {
        // Verifica se o usuário já existe
        if (userRepository.findByUsername(userCadastroDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already taken");
        }

        // Cria um novo usuário e define as propriedades
        User user = new User();
        user.setUsername(userCadastroDto.getUsername());
        user.setSenha(passwordEncoder.encode(userCadastroDto.getSenha()));

        // Define a Role padrão
        Role userRole = new Role();
        userRole.setNome("USER");
        user.getRoles().add(userRole);

        // Salva o usuário no repositório
        userRepository.save(user);
    }

}
