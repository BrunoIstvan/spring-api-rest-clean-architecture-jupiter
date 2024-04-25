package br.com.alura.codechella.infra.controllers;

import br.com.alura.codechella.application.usecases.user.*;
import br.com.alura.codechella.infra.controllers.dtos.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;
import java.util.stream.Stream;

import static br.com.alura.codechella.domain.entity.user.UserTest.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CreateUser createUser;

    @MockBean
    private UpdateUser updateUser;

    @MockBean
    private ListAllUsers listAllUsers;

    @MockBean
    private GetUser getUser;

    @MockBean
    private DeleteUser deleteUser;

    @Test
    void whenCallPostRequestWithCorrectData_shouldReturnAValidUserDTO() throws Exception {

        var dto = new UserDTO(null, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var expectedDTO = new UserDTO(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var expectedEntity = UserDTO.toEntity(expectedDTO);

        doReturn(expectedEntity).when(createUser).save(any());

        var perform = this.mockMvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(dto))
        );
        var response = perform.andReturn().getResponse();
        perform
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(100L))
                .andExpect(jsonPath("$.cpf").value(VALID_CPF))
                .andExpect(jsonPath("$.name").value(VALID_NAME))
                .andExpect(jsonPath("$.birthday").value(VALID_BIRTHDAY.toString()))
                .andExpect(jsonPath("$.email").value(VALID_EMAIL));
        assertTrue(Objects.requireNonNull(response.getHeader("location")).contains("/users/100"));
    }

    @Test
    void whenCallPatchRequestWithCorrectData_shouldReturnAValidUserDTO() throws Exception {

        var dto = new UserDTO(null, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var expectedDTO = new UserDTO(100L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var expectedEntity = UserDTO.toEntity(expectedDTO);

        doReturn(expectedEntity).when(updateUser).update(any());

        var perform = this.mockMvc.perform(
                patch("/users/100")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(dto))
        );

        perform
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(100L))
                .andExpect(jsonPath("$.cpf").value(VALID_CPF))
                .andExpect(jsonPath("$.name").value(VALID_NAME))
                .andExpect(jsonPath("$.birthday").value(VALID_BIRTHDAY.toString()))
                .andExpect(jsonPath("$.email").value(VALID_EMAIL));
    }

    @Test
    void whenCallGetRequest_shouldReturnAValidListOfUserDTOs() throws Exception {

        var dto1 = new UserDTO(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var dto2 = new UserDTO(2L, "123.456.789-99", "João", VALID_BIRTHDAY, "joao@email.com");
        var dto3 = new UserDTO(3L, "323.456.789-99", "Pedro", VALID_BIRTHDAY, "pedro@email.com");

        var expectedEntities = Stream.of(dto1, dto2, dto3).map(UserDTO::toEntity).toList();

        doReturn(expectedEntities).when(listAllUsers).list();

        var perform = this.mockMvc.perform(
                get("/users")
                        .contentType(MediaType.APPLICATION_JSON));

        perform
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(dto1.id()))
                .andExpect(jsonPath("$[0].cpf").value(dto1.cpf()))
                .andExpect(jsonPath("$[1].name").value(dto2.name()))
                .andExpect(jsonPath("$[1].birthday").value(dto2.birthday().toString()))
                .andExpect(jsonPath("$[2].email").value(dto3.email()));
    }

    @Test
    void whenCallGetByIdRequest_shouldReturnAValidUserDTO() throws Exception {

        var dto1 = new UserDTO(1L, VALID_CPF, VALID_NAME, VALID_BIRTHDAY, VALID_EMAIL);
        var expectedEntity = UserDTO.toEntity(dto1);

        doReturn(expectedEntity).when(getUser).getById(1L);

        var perform = this.mockMvc.perform(
                get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON));

        perform
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.cpf").value(VALID_CPF))
                .andExpect(jsonPath("$.name").value(VALID_NAME))
                .andExpect(jsonPath("$.birthday").value(VALID_BIRTHDAY.toString()))
                .andExpect(jsonPath("$.email").value(VALID_EMAIL));
    }

    @Test
    void whenCallGetByIdRequestWithUnknownId_shouldReturnStatusCode404() throws Exception {

        doReturn(null).when(getUser).getById(1L);

        var perform = this.mockMvc.perform(
                get("/users/1000")
                        .contentType(MediaType.APPLICATION_JSON));

        perform
                .andExpect(status().isNotFound());
    }

    @Test
    void whenCallDeletetByIdRequest_shouldReturnStatusCode200() throws Exception {

        doNothing().when(deleteUser).delete(1L);

        var perform = this.mockMvc.perform(
                delete("/users/1")
                        .contentType(MediaType.APPLICATION_JSON));

        perform
                .andExpect(status().isOk());
    }
}