package com.project.crystalball.mapper.contribution;

import com.project.crystalball.dto.contribution.Contribution;
import com.project.crystalball.entity.contribution.ContributionEntity;
import com.project.crystalball.mapper.AbstractDtoEntityMapper;
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