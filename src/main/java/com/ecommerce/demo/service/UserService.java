package com.ecommerce.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.entity.User;
import com.ecommerce.demo.exceptions.CredenciaisInvalidas;
import com.ecommerce.demo.exceptions.RequisicaoInvalida;
import com.ecommerce.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired // Injeta automaticamente um objeto da classe ProdutoRepository
    private UserRepository userRepository;

    public User register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RequisicaoInvalida("Nome de usuário já está em uso.");
        }

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new CredenciaisInvalidas("Usuário ou senha inválidos.");
        }
        return user;
    }
}
