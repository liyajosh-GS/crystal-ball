package com.project.crystalBall.repository;

import com.project.crystalBall.entity.project.ProjectEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    @Query(nativeQuery = true, value = "select * from project where is_archived = :isArchived")
    List<ProjectEntity> findByProjectStatus(@Param("isArchived") boolean isArchived);
}
