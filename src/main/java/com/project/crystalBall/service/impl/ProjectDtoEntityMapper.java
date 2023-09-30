package com.project.crystalBall.service.impl;

import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.service.DtoEntityMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoEntityMapper implements DtoEntityMapper<Project, ProjectEntity> {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Project convertToDto(ProjectEntity entity) {
        return modelMapper.map(entity, Project.class);
    }

    @Override
    public ProjectEntity convertToEntity(Project dto) {
        return modelMapper.map(dto, ProjectEntity.class);
    }
}
