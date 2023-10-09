package com.project.crystalBall.mapper.project;

import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.mapper.AbstractDtoEntityMapper;
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
