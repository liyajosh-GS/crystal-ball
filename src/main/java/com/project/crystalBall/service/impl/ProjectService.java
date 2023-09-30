package com.project.crystalBall.service.impl;

import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.dto.project.ProjectPatchContributionsDto;
import com.project.crystalBall.entity.Contribution;
import com.project.crystalBall.entity.project.FundingStatus;
import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService extends AbstractCrudService<Project, Long, ProjectEntity>{

    @Autowired
    ProjectRepository repository;

    @Autowired
    ProjectDtoEntityMapper mapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ProjectDtoEntityMapper mapper) {
        super(projectRepository, mapper);
    }

    @Override
    public Project create(Project dto) {
        ProjectEntity entity = mapper.convertToEntity(dto);
        entity.setFundingStatus(FundingStatus.PENDING);
        entity.setContributions(new ArrayList<>());
        repository.save(entity);
        return mapper.convertToDto(entity);
    }

    @Override
    public Project update(Project project) {
        return null;
    }

    public void patchUpdate(Long id, Project project){
        Optional<ProjectEntity> existingEntity = repository.findById(id);
        if(existingEntity.isPresent()){
            ProjectEntity entity = existingEntity.get();
            entity.setProjectType(project.getProjectType());
            entity.setName(project.getName());
            entity.setDescription(project.getDescription());
            entity.setTargetFund(project.getTargetFund());
            entity.setRecordUpdateTime(project.getUpdateTime());
            repository.save(entity);
        }
    }

    public void updateContributions(Long id, ProjectPatchContributionsDto patchContributionsDto){
        Optional<ProjectEntity> existingEntity = repository.findById(id);
        if(existingEntity.isPresent()){
            ProjectEntity entity = existingEntity.get();

            List<Contribution> contributions = entity.getContributions();
            contributions.addAll(patchContributionsDto.getContributions());
            entity.setContributions(contributions);

            boolean isTargetAchieved = contributions.stream()
                    .mapToDouble(Contribution::getAmount)
                    .sum() >= entity.getTargetFund();
            if(isTargetAchieved){
                entity.setFundingStatus(FundingStatus.COMPLETE);
            }

            repository.save(entity);
        }
    }
}
