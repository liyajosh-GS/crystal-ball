package com.project.crystalball.repository;

import com.project.crystalball.entity.contribution.ContributionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<ContributionEntity, Long> {

}
