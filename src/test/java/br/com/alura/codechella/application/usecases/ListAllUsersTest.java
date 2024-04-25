package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.application.usecases.user.ListAllUsers;
import br.com.alura.codechella.domain.entity.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;

import static br.com.alura.codechella.domain.entity.user.UserTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class ListAllUsersTest {

    @Mock
    private UserApplication application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(UserApplication.class);
    }

    @Test
    void whenExecuteUpdate_shouldUpdateDataAndReturnEntity() {

        var entity1 = new User(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, VALID_ADDRESS);
        var entity2 = new User(2L, "123.456.789-22", "UserName", LocalDate.now().plusDays(-10), "bla@email.com", null);
        doReturn(Arrays.asList(entity1,  entity2)).when(application).listAll();
        var listAllUser = new ListAllUsers(application);
        var result = listAllUser.list();
        assertNotNull(result);
        assertEquals(result.get(0).getCpf(), VALID_CPF);
        assertEquals(result.get(1).getCpf(), "123.456.789-22");
        assertEquals(result.get(0).getId(), 1L);
        assertEquals(result.get(1).getId(), 2L);

    }

}