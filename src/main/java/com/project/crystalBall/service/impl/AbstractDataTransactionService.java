package com.project.crystalBall.service.impl;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractEntity;
import com.project.crystalBall.service.DataTransactionService;
import com.project.crystalBall.mapper.DtoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDataTransactionService<D extends AbstractDto, K extends Long, E extends AbstractEntity> extends AbstractFinalDataTransactionService<D, K, E> implements DataTransactionService<D, K, E> {

    private static final String READ_ALL_KEY = "recordUpdateTime";
    @Autowired
    private JpaRepository repository;

    @Autowired
    DtoEntityMapper<D, E> mapper;


    protected AbstractDataTransactionService(DtoEntityMapper<D, E> mapper){
        super(mapper);
        this.repository = getRepository();
        this.mapper = mapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public D update(D dto) {
        E entity = mapper.convertToEntity(dto);
        repository.save(entity);
        return mapper.convertToDto(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
