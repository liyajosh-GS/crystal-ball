package com.project.crystalBall.repository.project;

import com.project.crystalBall.entity.project.ProjectEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    @Query(nativeQuery = true, value = "select * from project where is_archived = :isArchived order by created_time desc")
    List<ProjectEntity> findByProjectStatus(@Param("isArchived") boolean isArchived);
}
