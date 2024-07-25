package br.com.alura.codechella.application.usecase;

import br.com.alura.codechella.application.gateway.UserRepository;

public class DeleteUser {

    private final UserRepository userRepository;

    public DeleteUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String cpf) {
        userRepository.delete(cpf);
    }
}
