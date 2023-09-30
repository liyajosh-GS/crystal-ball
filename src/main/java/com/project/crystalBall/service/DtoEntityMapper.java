package com.project.crystalBall.service;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractEntity;

public interface DtoEntityMapper<D extends AbstractDto, E extends AbstractEntity> {

    D convertToDto(E entity);

    E convertToEntity(D dto);

}
