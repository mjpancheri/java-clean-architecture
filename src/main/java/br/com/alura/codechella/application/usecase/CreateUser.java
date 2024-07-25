package br.com.alura.codechella.application.usecase;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entity.user.User;

public class CreateUser {

    private final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        return userRepository.save(user);
    }
}
