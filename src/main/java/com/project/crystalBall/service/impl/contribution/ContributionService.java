package com.project.crystalBall.service.impl.contribution;

import com.project.crystalBall.dto.contribution.Contribution;
import com.project.crystalBall.entity.contribution.ContributionEntity;
import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.exception.NoSuchItemFoundException;
import com.project.crystalBall.repository.contribution.ContributionRepository;
import com.project.crystalBall.repository.project.ProjectRepository;
import com.project.crystalBall.service.impl.AbstractFinalDataTransactionService;
import com.project.crystalBall.mapper.contribution.ContributionDtoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContributionService extends AbstractFinalDataTransactionService<Contribution, Long, ContributionEntity> {

    @Autowired
    ContributionRepository contributionRepository;

    @Autowired
    ContributionDtoEntityMapper mapper;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    public ContributionService(ContributionDtoEntityMapper mapper) {
        super(mapper);
    }

    @Override
    public Contribution create(Contribution contribution){
        ContributionEntity contributionEntity = mapper.convertToEntity(contribution);

        Optional<ProjectEntity> existingProject = projectRepository.findById(contribution.getProjectId());
        ProjectEntity projectEntity = existingProject.orElseThrow(() -> new NoSuchItemFoundException("Project does not exist"));

        if(projectEntity.getIsArchived()){
            throw new RuntimeException("Project stopped raising fund");
        }

        Double updatedFund = contributionEntity.getAmount() + projectEntity.getCollectedFund();
        if(updatedFund >= projectEntity.getTargetFund()){
            projectEntity.setIsArchived(Boolean.TRUE);
        }
        projectEntity.setCollectedFund(updatedFund);

        contributionRepository.save(contributionEntity);
        projectRepository.save(projectEntity);

        return contribution;

    }

    @Override
    public JpaRepository<ContributionEntity, Long> getRepository() {
        return contributionRepository;
    }

}
