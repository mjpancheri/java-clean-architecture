package br.com.alura.codechella.domain.entity.user;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testCPFIsValid() {
        assertThrows(IllegalArgumentException.class,
                () -> new User(null, "John Doe", "1974-11-28", "john.doe@example.com"));
        assertThrows(IllegalArgumentException.class,
                () -> new User("           ", "John Doe", "1974-11-28", "john.doe@example.com"));
        assertThrows(IllegalArgumentException.class,
                () -> new User("", "John Doe", "1974-11-28", "john.doe@example.com"));
        assertThrows(IllegalArgumentException.class,
                () -> new User("asdfghjkl", "John Doe", "1974-11-28", "john.doe@example.com"));

        assertDoesNotThrow(
                () -> new User("12345678900", "John Doe", "1974-11-28", "john.doe@example.com"));
        assertDoesNotThrow(
                () -> new User("123.456.789-00", "John Doe", "1974-11-28", "john.doe@example.com"));
    }

    @Test
    void testCreateUserWithBuilder() {
        UserBuilder userBuilder = new UserBuilder();
        User user = userBuilder.withCpfNameBirth("12345678900", "John Doe", "1974-11-28");

        assertEquals("12345678900", user.getCpf());
        assertEquals("John Doe", user.getName());
        assertEquals("1974-11-28", user.getBirth().format(User.BIRTH_FORMATTER));
    }

    @Test
    void testIncludeAddressWithBuilder() {
        UserBuilder userBuilder = new UserBuilder();
        User user = userBuilder.withCpfNameBirth("12345678900", "John Doe", "1974-11-28");
        user = userBuilder.addAddress("12345000", "123", "house 5");

        assertEquals("12345000", user.getAddress().getZipCode());
        assertEquals("123", user.getAddress().getNumber());
        assertEquals("house 5", user.getAddress().getComplement());
        assertEquals("12345678900", user.getCpf());
    }

    @Test
    void testNotCreateAgeLess18() {
        LocalDate birth = LocalDate.now().minusYears(17);

        assertThrows(IllegalArgumentException.class,
                () -> new User("12345678900", "John Doe", birth.format(User.BIRTH_FORMATTER), "john.doe@example.com"));

    }
}