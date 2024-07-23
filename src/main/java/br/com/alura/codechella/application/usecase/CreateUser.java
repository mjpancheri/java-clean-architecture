package br.com.alura.codechella.application.usecase;

import br.com.alura.codechella.application.gateway.UserReposutory;
import br.com.alura.codechella.domain.entity.user.User;

public class CreateUser {

    private final UserReposutory userReposutory;

    public CreateUser(UserReposutory userReposutory) {
        this.userReposutory = userReposutory;
    }

    public User execute(User user) {
        return userReposutory.save(user);
    }
}
