package br.com.alura.codechella.application.gateway;

import br.com.alura.codechella.domain.entity.user.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    List<User> findAll();

    User findOne(String cpf);

    void delete(String cpf);

    User update(String cpf, User user);
}
