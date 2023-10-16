package com.project.crystalBall.repository.contribution;

import com.project.crystalBall.entity.contribution.ContributionEntity;
import com.project.crystalBall.repository.RepositoryFactory;
import com.project.crystalBall.repository.contribution.ContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContributionRepositoryFactory implements RepositoryFactory<ContributionEntity, Long> {

    @Autowired
    ContributionRepository contributionRepository;

    @Override
    public ContributionRepository getRepository() {
        return contributionRepository;
    }
}
