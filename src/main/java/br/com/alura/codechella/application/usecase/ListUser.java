package br.com.alura.codechella.application.usecase;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entity.user.User;

import java.util.List;

public class ListUser {

    private final UserRepository userRepository;

    public ListUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.findAll();
    }
}
