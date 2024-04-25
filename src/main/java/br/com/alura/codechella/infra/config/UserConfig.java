package br.com.alura.codechella.infra.config;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.application.usecases.user.*;
import br.com.alura.codechella.infra.gateways.user.UserMapper;
import br.com.alura.codechella.infra.gateways.user.UserRepositoryJpa;
import br.com.alura.codechella.infra.persistence.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public UserRepositoryJpa userRepositoryJpa( UserRepository repository,
                                                UserMapper mapper) {
        return new UserRepositoryJpa(repository, mapper);
    }

    @Bean
    public CreateUser createUser(UserApplication application) {
        return new CreateUser(application);
    }

    @Bean
    public UpdateUser updateUser(UserApplication application) {
        return new UpdateUser(application);
    }

    @Bean
    public DeleteUser deleteUser(UserApplication application) {
        return new DeleteUser(application);
    }

    @Bean
    public GetUser getUser(UserApplication application) {
        return new GetUser(application);
    }

    @Bean
    public ListAllUsers listAllUsers(UserApplication application) {
        return new ListAllUsers(application);
    }

}
