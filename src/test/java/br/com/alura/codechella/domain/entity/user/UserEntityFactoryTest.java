package br.com.alura.codechella.domain.entity.user;

import org.junit.jupiter.api.Test;

import static br.com.alura.codechella.domain.entity.user.UserEntityTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserEntityFactoryTest {


    @Test
    void whenInsertValidData_shouldReturnUserObject() {

        var factory = new UserFactory();

        var user1 = factory.withCpfNameBirthdayEmail(VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        assertNotNull(user1);

        var user2 = factory.withAddress(VALID_ADDRESS.getCep(), VALID_ADDRESS.getNumber(), VALID_ADDRESS.getComplement());
        assertNotNull(user2);

        var user3 = factory.withId(2L);
        assertNotNull(user3);

        assertEquals(user3.getId(), 2L);
        assertEquals(user3.getCpf(), VALID_CPF);
        assertEquals(user3.getFullName(), VALID_NAME);
        assertEquals(user3.getBirthday(), VALID_BIRTHDAY);
        assertEquals(user3.getEmail(), VALID_EMAIL);
        assertEquals(user3.getAddress(), VALID_ADDRESS);

    }

}