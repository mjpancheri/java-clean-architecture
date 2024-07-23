package br.com.alura.codechella.infrastructure.gateway;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entity.user.User;
import br.com.alura.codechella.infrastructure.persistence.UserEntity;
import br.com.alura.codechella.infrastructure.persistence.UserEntityRepository;

import java.util.List;

public class UserRepositoryJpa implements UserRepository {

    private final UserEntityRepository repository;
    private final UserEntityMapper mapper;

    public UserRepositoryJpa(UserEntityRepository repository, UserEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }
}
