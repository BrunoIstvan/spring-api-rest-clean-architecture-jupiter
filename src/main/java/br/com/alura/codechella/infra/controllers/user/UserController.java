package br.com.alura.codechella.infra.controllers.user;

import br.com.alura.codechella.application.usecases.user.*;
import br.com.alura.codechella.domain.entity.user.UserFactory;
import br.com.alura.codechella.infra.controllers.dtos.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;
    private final GetUser getUser;
    private final ListAllUsers listAllUsers;

    public UserController(CreateUser createUser, UpdateUser updateUser, DeleteUser deleteUser, GetUser getUser, ListAllUsers listAllUsers) {
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
        this.getUser = getUser;
        this.listAllUsers = listAllUsers;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> insertUser(@RequestBody @Valid UserDTO user, UriComponentsBuilder uriBuilder) {
        var factory = new UserFactory();
        var entity = factory.withCpfNameBirthdayEmail(user.cpf(), user.name(), user.birthday(), user.email());
        var newEntity = createUser.save(entity);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(newEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(UserDTO.toDTO(newEntity));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserDTO user) {
        var factory = new UserFactory();
        var entity = factory.withCpfNameBirthdayEmail(user.cpf(), user.name(), user.birthday(), user.email());
        entity = factory.withId(id);
        var newEntity = updateUser.update(entity);
        return ResponseEntity.ok(UserDTO.toDTO(newEntity));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listAllUsers() {
        var usersEntity = listAllUsers.list();
        var usersDto = usersEntity.stream().map(UserDTO::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        var userEntity = getUser.getById(id);
        if(userEntity == null) {
            return ResponseEntity.notFound().build();
        }
        var userDto = UserDTO.toDTO(userEntity);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
        deleteUser.delete(id);
        return ResponseEntity.ok().build();
    }

}
