package br.com.alura.codechella.infra.controllers.dtos;

import br.com.alura.codechella.domain.entity.user.User;
import org.junit.jupiter.api.Test;

import static br.com.alura.codechella.domain.entity.user.UserTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserDTOTest {

    @Test
    void whenPassAllDTOData_shouldReturnUserEntity() {

        var dto = new UserDTO(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var result = UserDTO.toEntity(dto);
        assertNotNull(result);
        assertEquals(result.getCpf(), VALID_CPF);
        assertEquals(result.getFullName(), VALID_NAME);
        assertEquals(result.getBirthday(), VALID_BIRTHDAY);
        assertEquals(result.getEmail(), VALID_EMAIL);
        assertEquals(result.getId(), 1L);

    }

    @Test
    void whenPassAllEntityData_shouldReturnUserDTO() {

        var entity = new User(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        var result = UserDTO.toDTO(entity);
        assertNotNull(result);
        assertEquals(result.cpf(), VALID_CPF);
        assertEquals(result.name(), VALID_NAME);
        assertEquals(result.birthday(), VALID_BIRTHDAY);
        assertEquals(result.email(), VALID_EMAIL);
        assertEquals(result.id(), 1L);

    }


}