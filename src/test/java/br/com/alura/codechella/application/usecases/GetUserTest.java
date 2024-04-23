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

class GetUserTest {

    @Mock
    private UserApplication application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(UserApplication.class);
    }

    @Test
    void whenExecuteGetById_shouldReturnEntity() {

        var entity = new UserEntity(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        doReturn(entity).when(application).getById(1L);
        var getUser = new GetUser(application);
        var result = getUser.getById(1L);
        assertNotNull(result);
        assertEquals(result.getCpf(), VALID_CPF);

    }
}