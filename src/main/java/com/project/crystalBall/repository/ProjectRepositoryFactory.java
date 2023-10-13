package com.project.crystalBall.repository;

import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class ProjectRepositoryFactory implements RepositoryFactory<ProjectEntity, Long>{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public ProjectRepository getRepository()  {
//        if(entityClass.equals(ProjectEntity.class)){
//            return (JpaRepository<T, Long>) projectRepository;
//        }
//        throw new IllegalAccessException("Unsupported entity");
        return projectRepository;
    }
}
