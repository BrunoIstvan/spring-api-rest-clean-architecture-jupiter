package br.com.alura.codechella.infra.gateways.user;

import br.com.alura.codechella.domain.entity.user.UserEntity;
import br.com.alura.codechella.infra.persistence.user.UserModel;
import org.junit.jupiter.api.Test;

import static br.com.alura.codechella.domain.entity.user.UserEntityTest.*;
import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void whenPassAllModelData_shouldReturnUserEntity() {

        var mapper = new UserMapper();
        var model = new UserModel(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var result = mapper.toEntity(model);
        assertNotNull(result);
        assertEquals(result.getCpf(), VALID_CPF);
        assertEquals(result.getFullName(), VALID_NAME);
        assertEquals(result.getBirthday(), VALID_BIRTHDAY);
        assertEquals(result.getEmail(), VALID_EMAIL);
        assertEquals(result.getId(), 1L);

    }

    @Test
    void whenPassAllEntityData_shouldReturnUserModel() {

        var mapper = new UserMapper();
        var entity = new UserEntity(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        var result = mapper.toModel(entity);
        assertNotNull(result);
        assertEquals(result.getCpf(), VALID_CPF);
        assertEquals(result.getFullName(), VALID_NAME);
        assertEquals(result.getBirthday(), VALID_BIRTHDAY);
        assertEquals(result.getEmail(), VALID_EMAIL);
        assertEquals(result.getId(), 1L);

    }
}