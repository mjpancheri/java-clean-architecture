package br.com.alura.codechella.domain.entity.user;

import br.com.alura.codechella.domain.Address;

public class UserBuilder {

    private User user;

    public User withCpfNameBirth(String cpf, String name, String birth) {
        this.user = new User(cpf, name, birth, null);
        return this.user;
    }

    public User addAddress(String zipCode, String number, String complement) {
        this.user.setAddress(new Address(zipCode, number, complement));
        return this.user;
    }
}
