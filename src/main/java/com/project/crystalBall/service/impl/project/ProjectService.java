package com.project.crystalBall.service.impl.project;

import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.mapper.project.ProjectDtoEntityMapper;
import com.project.crystalBall.repository.ProjectRepository;
import com.project.crystalBall.service.impl.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ProjectService extends AbstractCrudService<Project, Long, ProjectEntity> {

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