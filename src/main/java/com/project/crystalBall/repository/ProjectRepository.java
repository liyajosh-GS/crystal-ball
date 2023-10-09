package com.project.crystalball.repository;

import com.project.crystalball.entity.project.ProjectEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    @Query(nativeQuery = true, value = "select * from project where is_archived = :isArchived")
    List<ProjectEntity> findByProjectStatus(@Param("isArchived") boolean isArchived);
}
