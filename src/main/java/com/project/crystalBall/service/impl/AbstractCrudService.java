package com.project.crystalball.service.impl;

import com.project.crystalball.dto.AbstractDto;
import com.project.crystalball.entity.AbstractEntity;
import com.project.crystalball.exception.NoSuchItemFoundException;
import com.project.crystalball.service.CrudService;
import com.project.crystalball.mapper.DtoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public abstract class AbstractCrudService<D extends AbstractDto, K extends Long, E extends AbstractEntity> implements CrudService<D, K, E> {

    private static final String READ_ALL_KEY = "recordUpdateTime";
    @Autowired
    private JpaRepository repository;

    @Autowired
    DtoEntityMapper<D, E> mapper;

    protected AbstractCrudService(JpaRepository repository, DtoEntityMapper<D, E> mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public D create(D dto) {
        E entity = mapper.convertToEntity(dto);
        repository.save(entity);
        return mapper.convertToDto(entity);
    }
    @Override
    public D update(D dto) {
        E entity = mapper.convertToEntity(dto);
        repository.save(entity);
        return mapper.convertToDto(entity);
    }

    @Override
    public D read(Long id) {
        Optional<E> entity = repository.findById(id);
        return entity.map(e -> mapper.convertToDto(e)).orElseThrow(() -> new NoSuchItemFoundException("Requested resource does not exist"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<D> readAll() {
        List<E> entities = repository.findAll();
        return entities.stream().map((entity) -> (D)mapper.convertToDto(entity)).collect(Collectors.toList());
    }
}
