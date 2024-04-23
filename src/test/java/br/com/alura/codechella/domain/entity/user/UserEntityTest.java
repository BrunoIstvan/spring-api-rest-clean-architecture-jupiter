package br.com.alura.codechella.domain.entity.user;

import br.com.alura.codechella.domain.Address;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserEntityTest {


    public static final String VALID_CPF = "123.456.789-01";
    public static final String INVALID_CPF = "12345678901";

    public static final String VALID_NAME = "Name of User";

    public static final LocalDate VALID_BIRTHDAY = LocalDate.now().plusDays(-1);
    public static final LocalDate INVALID_BIRTHDAY_1 = LocalDate.now().plusDays(1);
    public static final LocalDate INVALID_BIRTHDAY_TODAY = LocalDate.now();

    public static final String VALID_EMAIL = "email@email.com";
    public static final String INVALID_EMAIL = "email@email";

    public static final Address VALID_ADDRESS = new Address("01111-222", 100, null);


    @Test
    void whenInvalidCPF_shouldThrowsException() {

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(null, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(INVALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(1L, null, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(1L, INVALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS));

    }

    @Test
    void whenInvalidEmail_shouldThrowsException() {

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(VALID_CPF, VALID_NAME, VALID_BIRTHDAY, INVALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(VALID_CPF, VALID_NAME, VALID_BIRTHDAY, null, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, INVALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, null, VALID_ADDRESS));

    }

    @Test
    void whenInvalidFullName_shouldThrowsException() {

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(VALID_CPF, null, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(1L, VALID_CPF, null, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS));

    }

    @Test
    void whenInvalidBirthday_shouldThrowsException() {

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(VALID_CPF, VALID_NAME, INVALID_BIRTHDAY_1, VALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(VALID_CPF, VALID_NAME, INVALID_BIRTHDAY_TODAY, VALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(VALID_CPF, VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(1L, VALID_CPF, VALID_NAME, INVALID_BIRTHDAY_1, VALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(1L, VALID_CPF, VALID_NAME, LocalDate.now(), VALID_EMAIL, VALID_ADDRESS));

        assertThrows(IllegalArgumentException.class,
                () -> new UserEntity(1L, VALID_CPF, VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS));

    }

    @Test
    void whenValidUserData_shouldReturnAnFilledUserObject() {

        var user1 = new UserEntity(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        assertNotNull(user1);
        assertEquals(user1.getId(), 1L);
        assertEquals(user1.getCpf(), VALID_CPF);
        assertEquals(user1.getFullName(), VALID_NAME);
        assertEquals(user1.getBirthday(), VALID_BIRTHDAY);
        assertEquals(user1.getEmail(), VALID_EMAIL);
        assertEquals(user1.getAddress(), VALID_ADDRESS);

        var user2 = new UserEntity(VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        assertNotNull(user2);
        assertEquals(user2.getCpf(), VALID_CPF);
        assertEquals(user2.getFullName(), VALID_NAME);
        assertEquals(user2.getBirthday(), VALID_BIRTHDAY);
        assertEquals(user2.getEmail(), VALID_EMAIL);
        assertEquals(user2.getAddress(), VALID_ADDRESS);

    }

}