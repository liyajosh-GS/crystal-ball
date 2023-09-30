package com.project.crystalBall.service.impl;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractEntity;
import com.project.crystalBall.service.CrudService;
import com.project.crystalBall.service.DtoEntityMapper;
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
    private JpaRepository<E, Long> repository;

    @Autowired
    DtoEntityMapper<D, E> mapper;

    protected AbstractCrudService(JpaRepository<E, Long> repository, DtoEntityMapper<D, E> mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public abstract D create(D dto);

    public abstract D update(D dto);

    @Override
    public D read(Long id) {
        Optional entity = repository.findById(id);
        if(entity.isPresent()){
            return (D) entity.get();
        }
        return null;
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
