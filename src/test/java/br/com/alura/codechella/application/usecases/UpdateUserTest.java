package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static br.com.alura.codechella.domain.entity.user.UserEntityTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

class UpdateUserTest {

    @Mock
    private UserApplication application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(UserApplication.class);
    }

    @Test
    void whenExecuteUpdate_shouldUpdateDataAndReturnEntity() {

        var entityBefore = new UserEntity(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        var entityAfter = new UserEntity(1L, "123.456.789-22", VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        doReturn(entityAfter).when(application).update(entityBefore);
        var updateUser = new UpdateUser(application);
        var result = updateUser.update(entityBefore);
        assertNotNull(result);
        assertEquals(result.getCpf(), "123.456.789-22");

    }

}