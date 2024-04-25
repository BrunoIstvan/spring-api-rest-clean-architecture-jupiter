package br.com.alura.codechella.infra.gateways.user;

import br.com.alura.codechella.domain.entity.user.User;
import br.com.alura.codechella.infra.persistence.user.UserModel;
import br.com.alura.codechella.infra.persistence.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static br.com.alura.codechella.domain.entity.user.UserTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserRepositoryJpaTest {

    @MockBean
    private UserRepository repository;

    private UserRepositoryJpa userRepositoryJpa;

    @BeforeEach
    void setUp() {
        var mapper = new UserMapper();
        userRepositoryJpa = new UserRepositoryJpa(repository, mapper);
    }

    @Test
    void whenCallSaveWithValidEntity_shouldReturnNewUserEntity() {

        var model = new UserModel(null, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var expectedModel = new UserModel(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        doReturn(expectedModel).when(repository).save(model);
        var entity = new User(null, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, null);

        var result = userRepositoryJpa.save(entity);
        assertNotNull(result);
        assertEquals(result.getId(), model.getId());

    }

    @Test
    void whenCallUpdateWithValidEntity_shouldReturnUserEntity() {

        var model = new UserModel(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var expectedModel = new UserModel(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        doReturn(expectedModel).when(repository).save(model);
        var entity = new User(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL, null);

        var result = userRepositoryJpa.update(entity);
        assertNotNull(result);
        assertEquals(result.getId(), model.getId());

    }


    @Test
    void whenCallDeleteWithId_shouldReturnNothing() {

        doNothing().when(repository).deleteById(100L);

        userRepositoryJpa.delete(100L);

        verify(repository, times(1)).deleteById(100L);

    }

    @Test
    void whenCallGetByIdWithValidId_shouldReturnUserEntity() {

        var model = new UserModel(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var expectedModel = new UserModel(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        doReturn(Optional.of(expectedModel)).when(repository).findById(100L);

        var result = userRepositoryJpa.getById(100L);
        assertNotNull(result);
        assertEquals(result.getId(), model.getId());

    }

    @Test
    void whenCallListAllWithValidId_shouldReturnAListOfUserEntities() {

        var model1 = new UserModel(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var model2 = new UserModel(200L, "555.666.777-33", VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var model3 = new UserModel(300L, "666.666.777-33", VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var listModels = Arrays.asList(model1, model2, model3);
        doReturn(listModels).when(repository).findAll();

        var result = userRepositoryJpa.listAll();
        assertNotNull(result);
        assertEquals(result.size(), listModels.size());
        for(int i = 0; i < 3; i++) {
            assertEquals(result.get(i).getEmail(), listModels.get(i).getEmail());
            assertEquals(result.get(i).getId(), listModels.get(i).getId());
        }

    }

}