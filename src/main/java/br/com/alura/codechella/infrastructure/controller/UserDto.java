package br.com.alura.codechella.infrastructure.controller;

import java.time.LocalDate;

public record UserDto(String cpf, String name, String birth, String email) {
}
