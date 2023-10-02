package com.project.crystalBall.mapper.contribution;

import com.project.crystalBall.dto.contribution.Contribution;
import com.project.crystalBall.entity.contribution.ContributionEntity;
import com.project.crystalBall.mapper.AbstractDtoEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ContributionDtoEntityMapper extends AbstractDtoEntityMapper<Contribution, ContributionEntity> {

    @Override
    protected Class<Contribution> getDtoClass() {
        return Contribution.class;
    }

    @Override
    protected Class<ContributionEntity> getEntityClass() {
        return ContributionEntity.class;
    }
}