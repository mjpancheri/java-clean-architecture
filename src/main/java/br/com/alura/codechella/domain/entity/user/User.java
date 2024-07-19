package br.com.alura.codechella.domain.entity.user;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {

    public static final DateTimeFormatter BIRTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private String cpf;
    private String name;
    private LocalDate birth;
    private String email;
    private Address address;

    public User(String cpf, String name, String birth, String email) {
        // validate CPF
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF is required");
        }
        cpf = cpf.replaceAll("\\D", "");
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        // validate age
        if (LocalDate.now().minusYears(18).isBefore(LocalDate.parse(birth, BIRTH_FORMATTER))) {
            throw new IllegalArgumentException("User must be at least 18 years old");
        }

        this.cpf = cpf;
        this.name = name;
        this.birth = LocalDate.parse(birth, BIRTH_FORMATTER);
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
