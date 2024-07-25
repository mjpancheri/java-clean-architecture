package br.com.alura.codechella.infrastructure.controller;

import br.com.alura.codechella.application.usecase.CreateUser;
import br.com.alura.codechella.application.usecase.DeleteUser;
import br.com.alura.codechella.application.usecase.FindUser;
import br.com.alura.codechella.application.usecase.ListUser;
import br.com.alura.codechella.application.usecase.UpdateUser;
import br.com.alura.codechella.domain.entity.user.User;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final ListUser listUser;
    private final FindUser findUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;

    public UserController(CreateUser createUser, ListUser listUser, FindUser findUser, UpdateUser updateUser, DeleteUser deleteUser) {
        this.createUser = createUser;
        this.listUser = listUser;
        this.findUser = findUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        User newUser = createUser.execute(new User(userDto.cpf(), userDto.name(), userDto.birth(), userDto.email()));

        return new UserDto(newUser.getCpf(), newUser.getName(), newUser.getBirth().format(User.BIRTH_FORMATTER), newUser.getEmail());
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return listUser.execute().stream()
                .map(user -> new UserDto(user.getCpf(), user.getName(), user.getBirth().format(User.BIRTH_FORMATTER), user.getEmail()))
                .toList();
    }

    @GetMapping("/{cpf}")
    public UserDto findUser(@PathVariable("cpf") String cpf) {
        var user = findUser.execute(cpf);

        return new UserDto(user.getCpf(), user.getName(), user.getBirth().format(User.BIRTH_FORMATTER), user.getEmail());
    }

    @PutMapping("/{cpf}")
    public UserDto updateUser(@PathVariable("cpf") String cpf, @RequestBody UserDto userDto) {
        var user = updateUser.execute(cpf, new User(userDto.cpf(), userDto.name(), userDto.birth(), userDto.email()));

        return new UserDto(user.getCpf(), user.getName(), user.getBirth().format(User.BIRTH_FORMATTER), user.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void deleteUser(@PathVariable("cpf") String cpf) {
        deleteUser.execute(cpf);
    }
}
