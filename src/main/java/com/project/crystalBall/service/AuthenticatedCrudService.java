package com.project.crystalBall.service;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.AbstractEntity;

@FunctionalInterface
public interface AuthenticatedCrudService<D extends AbstractDto, K extends Long, E extends AbstractEntity> {
    abstract D  authenticateUserAndSave(D d);
}
