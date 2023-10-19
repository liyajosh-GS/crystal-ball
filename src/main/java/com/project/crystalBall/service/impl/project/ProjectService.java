package com.project.crystalBall.service.impl.project;

import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.mapper.project.ProjectDtoEntityMapper;
import com.project.crystalBall.repository.project.ProjectRepository;
import com.project.crystalBall.service.impl.AbstractDataTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService extends AbstractDataTransactionService<Project, Long, ProjectEntity> {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectDtoEntityMapper mapper;

    @Autowired
    public ProjectService(ProjectDtoEntityMapper mapper) {
        super(mapper);
    }

    @Override
    public Project create(Project dto) {
        ProjectEntity entity = mapper.convertToEntity(dto);
        entity.setCollectedFund(0.00);
        entity.setIsArchived(Boolean.FALSE);
        projectRepository.save(entity);
        return mapper.convertToDto(entity);
    }

    @Override
    public JpaRepository<ProjectEntity, Long> getRepository() {
        return projectRepository;
    }

    public List<Project> readAllByStatus(Boolean isArchived) {
        List<ProjectEntity> entities = projectRepository.findByProjectStatus(isArchived);
        return entities.stream().map((entity) -> mapper.convertToDto(entity)).collect(Collectors.toList());
    }

}
