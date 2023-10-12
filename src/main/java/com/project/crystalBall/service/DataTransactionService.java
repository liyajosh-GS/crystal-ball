package com.project.crystalBall.service;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractEntity;

public interface DataTransactionService<D extends AbstractDto, K extends Long, E extends AbstractEntity> extends FinalDataTransactionService<D, K, E> {

    D update(D dto);

    void delete(Long id);

}
