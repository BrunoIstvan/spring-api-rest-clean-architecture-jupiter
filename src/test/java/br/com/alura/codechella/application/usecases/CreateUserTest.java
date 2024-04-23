package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static br.com.alura.codechella.domain.entity.user.UserEntityTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class CreateUserTest {

    @Mock
    private UserApplication application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(UserApplication.class);
    }

    @Test
    void whenExecuteSave_shouldSaveDataAndReturnEntity() {

        var entityBefore = new UserEntity(VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        var entityAfter = new UserEntity(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        doReturn(entityAfter).when(application).save(entityBefore);
        var createUser = new CreateUser(application);
        var result = createUser.save(entityBefore);
        assertNotNull(result);
        assertEquals(result.getCpf(), VALID_CPF);
        assertEquals(result.getId(), 100L);

    }
}