package com.project.crystalBall.mapper;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractEntity;
import com.project.crystalBall.entity.AbstractFinalEntity;
import org.springframework.stereotype.Component;

public interface DtoEntityMapper<D extends AbstractDto, E extends AbstractFinalEntity> {

    D convertToDto(E entity);

    E convertToEntity(D dto);

}
