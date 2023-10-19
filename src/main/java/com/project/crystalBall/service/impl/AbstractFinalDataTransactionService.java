package com.project.crystalBall.service.impl;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractFinalEntity;
import com.project.crystalBall.exception.NoSuchItemFoundException;
import com.project.crystalBall.mapper.DtoEntityMapper;
import com.project.crystalBall.service.FinalDataTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractFinalDataTransactionService<D extends AbstractDto, K extends Long, E extends AbstractFinalEntity> implements FinalDataTransactionService<D, K, E> {

    @Autowired
    private JpaRepository<E, K> repository;

    @Autowired
    DtoEntityMapper<D, E> mapper;

    protected AbstractFinalDataTransactionService(DtoEntityMapper<D, E> mapper)  {
        this.repository = getRepository();
        this.mapper = mapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public D create(D dto) {
        E entity = mapper.convertToEntity(dto);
        E createdEntity = (E) repository.save(entity);
        return mapper.convertToDto(createdEntity);
    }

    @Override
    public D read(K id) {
        Optional<E> entity = repository.findById(id);
        return entity.map(e -> mapper.convertToDto(e)).orElseThrow(() -> new NoSuchItemFoundException("Requested resource does not exist"));
    }

    @Override
    public List<D> readAll() {
        List<E> entities = repository.findAll();
        return entities.stream().map((entity) -> (D)mapper.convertToDto(entity)).collect(Collectors.toList());
    }

    public abstract JpaRepository<E, K> getRepository();
}
