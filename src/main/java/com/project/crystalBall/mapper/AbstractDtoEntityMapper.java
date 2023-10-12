package com.project.crystalBall.mapper;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractEntity;
import com.project.crystalBall.entity.AbstractFinalEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public abstract class AbstractDtoEntityMapper<D extends AbstractDto, E extends AbstractFinalEntity> implements DtoEntityMapper<D, E> {

    @Autowired
    ModelMapper modelMapper;
    private Class<E> entityClass;
    private Class<D> dtoClass;

    protected abstract Class<D> getDtoClass();
    protected abstract Class<E> getEntityClass();


    public AbstractDtoEntityMapper() {
        this.dtoClass = getDtoClass();
        this.entityClass = getEntityClass();
    }

    @Override
    public D convertToDto(E entity) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public E convertToEntity(D dto) {
        return modelMapper.map(dto, entityClass);
    }
}
