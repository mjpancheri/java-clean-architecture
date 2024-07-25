package br.com.alura.codechella.application.usecase;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entity.user.User;

public class UpdateUser {

    private final UserRepository userRepository;

    public UpdateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String cpf, User user) {
        return userRepository.update(cpf, user);
    }
}
