package com.project.crystalball.mapper;

import com.project.crystalball.dto.AbstractDto;
import com.project.crystalball.entity.AbstractEntity;

public interface DtoEntityMapper<D extends AbstractDto, E extends AbstractEntity> {

    D convertToDto(E entity);

    E convertToEntity(D dto);

}
