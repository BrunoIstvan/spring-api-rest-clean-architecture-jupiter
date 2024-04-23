package br.com.alura.codechella.infra.gateways.user;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.UserEntity;
import br.com.alura.codechella.infra.persistence.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryJpa implements UserApplication {

    private final UserRepository repository;

    private final UserMapper mapper;

    public UserRepositoryJpa(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserEntity save(UserEntity entity) {
        var model = mapper.toModel(entity);
        repository.save(model);
        return mapper.toEntity(model);
    }

    @Override
    public UserEntity update(UserEntity entity) {
        var model = mapper.toModel(entity);
        repository.save(model);
        return mapper.toEntity(model);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserEntity getById(Long id) {
        var model = repository.findById(id);
        return model.map(mapper::toEntity).orElse(null);
    }

    @Override
    public List<UserEntity> listAll() {
        return repository.findAll().stream().map(mapper::toEntity).collect(Collectors.toList());
    }
}
