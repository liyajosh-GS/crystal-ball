package com.project.crystalBall.repository.project;

import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.repository.RepositoryFactory;
import com.project.crystalBall.repository.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectRepositoryFactory implements RepositoryFactory<ProjectEntity, Long> {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public ProjectRepository getRepository()  {
        return projectRepository;
    }
}
