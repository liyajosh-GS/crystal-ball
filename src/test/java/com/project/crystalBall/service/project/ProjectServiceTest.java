package com.project.crystalball.service.project;

import com.project.crystalball.dto.project.Project;
import com.project.crystalball.entity.project.ProjectEntity;
import com.project.crystalball.mapper.project.ProjectDtoEntityMapper;
import com.project.crystalball.repository.ProjectRepository;
import com.project.crystalball.service.impl.project.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ProjectDtoEntityMapper projectDtoEntityMapper;
    

    @Mock
    private JpaRepository repository;

    @InjectMocks
    private ProjectService projectService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProject() {
        Project projectDto = new Project();
        ProjectEntity projectEntity = new ProjectEntity();

        when(projectDtoEntityMapper.convertToDto(projectEntity)).thenReturn(projectDto);
        when(projectDtoEntityMapper.convertToEntity(projectDto)).thenReturn(projectEntity);
        when(projectRepository.save(any(ProjectEntity.class))).thenReturn(projectEntity);

        Project createdProject = projectService.create(projectDto);

        assertEquals(projectDto, createdProject);

        verify(projectRepository, times(1)).save(any(ProjectEntity.class));
    }

    @Test
    public void testReadAllByStatus() {
        Boolean isArchived = Boolean.FALSE;
        List<ProjectEntity> projectEntities = new ArrayList<>();
        when(projectRepository.findByProjectStatus(isArchived)).thenReturn(projectEntities);

        List<Project> projectDtos = new ArrayList<>();
        lenient().when(projectDtoEntityMapper.convertToDto(any(ProjectEntity.class))).thenReturn(new Project());

        List<Project> projects = projectService.readAllByStatus(isArchived);

        assertEquals(projectDtos, projects);

        verify(projectRepository, times(1)).findByProjectStatus(isArchived);
    }
}
