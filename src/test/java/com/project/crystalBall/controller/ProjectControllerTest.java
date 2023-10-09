package com.project.crystalball.controller;

import com.project.crystalball.dto.project.Project;
import com.project.crystalball.service.impl.project.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectControllerTest {

    @InjectMocks
    private ProjectController projectController;

    @Mock
    private ProjectService projectService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProject() {
        Project project = new Project();
        project.setId(1L);
        project.setName("Sample Project");

        when(projectService.read(1L)).thenReturn(project);

        ResponseEntity<Project> responseEntity = projectController.getProject(1L);

        verify(projectService, times(1)).read(1L);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(project, responseEntity.getBody());
    }

    @Test
    public void testGetAllLiveProjects() {
        List<Project> liveProjects = Arrays.asList(new Project(), new Project());

        when(projectService.readAllByStatus(Boolean.FALSE)).thenReturn(liveProjects);

        ResponseEntity<List<Project>> responseEntity = projectController.getAllLiveProjects();

        verify(projectService, times(1)).readAllByStatus(Boolean.FALSE);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(liveProjects, responseEntity.getBody());
    }

    @Test
    public void testGetAllArchivedProjects() {
        List<Project> archivedProjects = Arrays.asList(new Project(), new Project());

        when(projectService.readAllByStatus(Boolean.TRUE)).thenReturn(archivedProjects);

        ResponseEntity<List<Project>> responseEntity = projectController.getAllArchivedProjects();

        verify(projectService, times(1)).readAllByStatus(Boolean.TRUE);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(archivedProjects, responseEntity.getBody());
    }

    @Test
    public void testCreateProject() {
        Project project = new Project();
        project.setId(1L);
        project.setName("Sample Project");

        when(projectService.create(project)).thenReturn(project);

        ResponseEntity<Project> responseEntity = projectController.create(project);

        verify(projectService, times(1)).create(project);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(project, responseEntity.getBody());
    }

    @Test
    public void testUpdateProject() {
        Project project = new Project();
        project.setId(1L);
        project.setName("Updated Project");

        when(projectService.update(project)).thenReturn(project);

        ResponseEntity<Project> responseEntity = projectController.update(project);

        verify(projectService, times(1)).update(project);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(project, responseEntity.getBody());
    }
}
