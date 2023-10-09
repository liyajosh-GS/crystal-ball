package com.project.crystalball.service;

import com.project.crystalball.dto.AbstractDto;
import com.project.crystalball.entity.AbstractEntity;

import java.util.List;

public interface CrudService<D extends AbstractDto, K extends Long, E extends AbstractEntity> {

    D create(D dto);

    D update(D dto);

    D read(Long id);

    void delete(Long id);

    List<D> readAll();
}
