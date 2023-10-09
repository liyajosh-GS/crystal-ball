package com.project.crystalBall.service;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractEntity;

import java.util.List;

public interface CrudService<D extends AbstractDto, K extends Long, E extends AbstractEntity> {

    D create(D dto);

    D update(D dto);

    D read(Long id);

    void delete(Long id);

    List<D> readAll();
}
