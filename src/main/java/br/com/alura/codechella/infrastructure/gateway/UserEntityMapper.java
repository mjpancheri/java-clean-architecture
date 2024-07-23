package br.com.alura.codechella.infrastructure.gateway;

import br.com.alura.codechella.domain.entity.user.User;
import br.com.alura.codechella.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getCpf(), user.getName(), user.getBirth(), user.getEmail());
    }

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getCpf(), userEntity.getName(), userEntity.getBirth().format(User.BIRTH_FORMATTER), userEntity.getEmail());
    }
}
