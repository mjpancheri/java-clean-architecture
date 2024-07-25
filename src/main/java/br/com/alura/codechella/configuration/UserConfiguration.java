package br.com.alura.codechella.configuration;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.application.usecase.CreateUser;
import br.com.alura.codechella.application.usecase.DeleteUser;
import br.com.alura.codechella.application.usecase.FindUser;
import br.com.alura.codechella.application.usecase.ListUser;
import br.com.alura.codechella.application.usecase.UpdateUser;
import br.com.alura.codechella.infrastructure.gateway.UserEntityMapper;
import br.com.alura.codechella.infrastructure.gateway.UserRepositoryJpa;
import br.com.alura.codechella.infrastructure.persistence.UserEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    CreateUser createUser(UserRepository userRepository) {
        return new CreateUser(userRepository);
    }

    @Bean
    ListUser listUser(UserRepository userRepository) {
        return new ListUser(userRepository);
    }

    @Bean
    FindUser findUser(UserRepository userRepository) {
        return new FindUser(userRepository);
    }

    @Bean
    UpdateUser updateUser(UserRepository userRepository) {
        return new UpdateUser(userRepository);
    }

    @Bean
    DeleteUser deleteUser(UserRepository userRepository) {
        return new DeleteUser(userRepository);
    }

    @Bean
    UserRepositoryJpa createUserRepositoryJpa(UserEntityRepository repository, UserEntityMapper mapper) {
        return new UserRepositoryJpa(repository, mapper);
    }

    @Bean
    UserEntityMapper createUserEntityMapper() {
        return new UserEntityMapper();
    }
}
