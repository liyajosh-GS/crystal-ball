package com.project.crystalBall.repository;

import com.project.crystalBall.entity.bankDetails.BankDetailsEntity;
import com.project.crystalBall.entity.contribution.ContributionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class ContributionRepositoryFactory implements RepositoryFactory<ContributionEntity, Long>{

    @Autowired
    ContributionRepository contributionRepository;

    @Override
    public ContributionRepository getRepository() {
//        if(entityClass.equals(ContributionEntity.class)){
//            return (JpaRepository<T, Long>) contributionRepository;
//        }
//        throw new IllegalAccessException("Unsupported entity");
        return contributionRepository;
    }
}
