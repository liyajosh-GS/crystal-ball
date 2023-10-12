package com.project.crystalBall.service;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractEntity;
import com.project.crystalBall.entity.AbstractFinalEntity;

import java.util.List;

public interface FinalDataTransactionService<D extends AbstractDto, K extends Long, E extends AbstractFinalEntity> {

    D create(D dto);

    D read(Long id);

    List<D> readAll();
}
