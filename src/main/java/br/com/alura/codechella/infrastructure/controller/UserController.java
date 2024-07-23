package br.com.alura.codechella.infrastructure.controller;

import br.com.alura.codechella.application.usecase.CreateUser;
import br.com.alura.codechella.domain.entity.user.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;

    public UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        User newUser = createUser.execute(new User(userDto.cpf(), userDto.name(), userDto.birth(), userDto.email()));

        return new UserDto(newUser.getCpf(), newUser.getName(), newUser.getBirth().format(User.BIRTH_FORMATTER), newUser.getEmail());
    }
}
