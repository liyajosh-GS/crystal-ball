package com.project.crystalball.service.impl.project;

import com.project.crystalball.dto.project.Project;
import com.project.crystalball.entity.project.ProjectEntity;
import com.project.crystalball.mapper.project.ProjectDtoEntityMapper;
import com.project.crystalball.repository.ProjectRepository;
import com.project.crystalball.service.impl.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
