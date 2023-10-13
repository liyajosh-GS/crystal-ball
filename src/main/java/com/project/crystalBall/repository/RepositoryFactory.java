package com.project.crystalBall.repository;


import com.project.crystalBall.entity.AbstractFinalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RepositoryFactory<E extends AbstractFinalEntity, K extends Long> {
    JpaRepository<E, K> getRepository();
}