package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.application.usecases.user.DeleteUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class DeleteUserTest {

    @Mock
    private UserApplication application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(UserApplication.class);
    }

    @Test
    void whenExecuteDelete_shouldDeleteData() {

        doNothing().when(application).delete(1L);
        var deleteUser = new DeleteUser(application);
        deleteUser.delete(1L);
        verify(application, times(1)).delete(1L);

    }
}