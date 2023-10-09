package com.project.crystalball.mapper;

import com.project.crystalball.dto.AbstractDto;
import com.project.crystalball.entity.AbstractEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractDtoEntityMapper<D extends AbstractDto, E extends AbstractEntity> implements DtoEntityMapper<D, E> {

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
