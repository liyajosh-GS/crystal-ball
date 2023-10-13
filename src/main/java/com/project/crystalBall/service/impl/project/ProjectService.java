package com.project.crystalBall.service.impl.project;

import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.mapper.project.ProjectDtoEntityMapper;
import com.project.crystalBall.repository.ProjectRepository;
import com.project.crystalBall.repository.ProjectRepositoryFactory;
import com.project.crystalBall.service.impl.AbstractDataTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService extends AbstractDataTransactionService<Project, Long, ProjectEntity> {

    @Autowired
    ProjectRepository repository;

    @Autowired
    ProjectDtoEntityMapper mapper;

    @Autowired
    ProjectRepositoryFactory projectRepositoryFactory;

    @Autowired
    public ProjectService(ProjectRepositoryFactory projectRepositoryFactory, ProjectDtoEntityMapper mapper) {
        super(projectRepositoryFactory, mapper);
    }

    @Override
    public Project create(Project dto) {
        ProjectEntity entity = mapper.convertToEntity(dto);
        entity.setCollectedFund(0.00);
        entity.setIsArchived(Boolean.FALSE);
        repository.save(entity);
        return mapper.convertToDto(entity);
    }

    public List<Project> readAllByStatus(Boolean isArchived) {
        List<ProjectEntity> entities = repository.findByProjectStatus(isArchived);
        return entities.stream().map((entity) -> mapper.convertToDto(entity)).collect(Collectors.toList());
    }

}
