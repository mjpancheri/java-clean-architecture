package br.com.alura.codechella.application.usecase;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entity.user.User;

public class FindUser {
    private final UserRepository userRepository;

    public FindUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String cpf) {
        return userRepository.findOne(cpf);
    }
}
