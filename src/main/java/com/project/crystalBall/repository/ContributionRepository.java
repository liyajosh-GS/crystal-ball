package com.project.crystalBall.repository;

import com.project.crystalBall.entity.contribution.ContributionEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<ContributionEntity, Long> {
}
