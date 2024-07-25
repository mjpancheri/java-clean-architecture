package br.com.alura.codechella.infrastructure.gateway;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entity.user.User;
import br.com.alura.codechella.infrastructure.persistence.UserEntity;
import br.com.alura.codechella.infrastructure.persistence.UserEntityRepository;

import java.util.List;
import java.util.Optional;

public class UserRepositoryJpa implements UserRepository {

    private final UserEntityRepository repository;
    private final UserEntityMapper mapper;

    public UserRepositoryJpa(UserEntityRepository repository, UserEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User save(User user) {
        var entity = mapper.toEntity(user);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(String cpf) {
        var entity = repository.findByCpf(cpf);
        repository.deleteById(entity.getId());
    }

    @Override
    public User findOne(String cpf) {
        var entity = repository.findByCpf(cpf);
        if (entity != null) {
            return mapper.toDomain(entity);
        }
        return null;
    }

    @Override
    public User update(String cpf, User user) {
        var entity = repository.findByCpf(cpf);
        if (entity != null) {
            var updatedEntity = mapper.toEntity(user);
            updatedEntity.setId(entity.getId());
            repository.save(updatedEntity);
            return mapper.toDomain(updatedEntity);
        }
        return null;
    }
}
