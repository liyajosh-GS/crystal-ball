package com.project.crystalball.mapper.project;

import com.project.crystalball.dto.project.Project;
import com.project.crystalball.entity.project.ProjectEntity;
import com.project.crystalball.mapper.AbstractDtoEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoEntityMapper extends AbstractDtoEntityMapper<Project, ProjectEntity> {

    @Override
    protected Class<Project> getDtoClass() {
        return Project.class;
    }

    @Override
    protected Class<ProjectEntity> getEntityClass() {
        return ProjectEntity.class;
    }
}
