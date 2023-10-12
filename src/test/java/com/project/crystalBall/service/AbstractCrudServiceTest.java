package com.project.crystalBall.service;

import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.exception.NoSuchItemFoundException;
import com.project.crystalBall.mapper.DtoEntityMapper;
import com.project.crystalBall.mapper.project.ProjectDtoEntityMapper;
import com.project.crystalBall.repository.ProjectRepository;
import com.project.crystalBall.service.impl.AbstractDataTransactionService;
import com.project.crystalBall.service.impl.project.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AbstractCrudServiceTest {

    @Mock
    private JpaRepository repository;

    @Mock
    private DtoEntityMapper mapper;

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectDtoEntityMapper projectDtoEntityMapper;

    @InjectMocks
    private AbstractDataTransactionService abstractCrudService = new ProjectService(projectRepository, projectDtoEntityMapper );


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Project projectDto  = createSampleDto();

        ProjectEntity projectEntity = createSampleEntity();

        when(projectDtoEntityMapper.convertToEntity(projectDto )).thenReturn(projectEntity);
        when(projectDtoEntityMapper.convertToDto(projectEntity )).thenReturn(projectDto);
        when(projectRepository.save(projectEntity)).thenReturn(projectEntity);

        Project createdDto = (Project) abstractCrudService.create(projectDto );

        assertNotNull(createdDto);
        verify(projectDtoEntityMapper, times(1)).convertToEntity(projectDto);
        verify(projectDtoEntityMapper, times(1)).convertToDto(projectEntity);

    }

    @Test
    public void testUpdate() {
        Project projectDto  = createSampleDto();

        ProjectEntity projectEntity = createSampleEntity();

        when(projectDtoEntityMapper.convertToEntity(projectDto )).thenReturn(projectEntity);
        when(projectDtoEntityMapper.convertToDto(projectEntity )).thenReturn(projectDto);
        when(projectRepository.save(projectEntity)).thenReturn(projectEntity);

        Project updatedDto = (Project) abstractCrudService.update(projectDto );

        assertNotNull(updatedDto);
        verify(projectDtoEntityMapper, times(1)).convertToEntity(projectDto);
        verify(projectDtoEntityMapper, times(1)).convertToDto(projectEntity);
    }

    @Test
    public void testRead() {
        Project projectDto  = createSampleDto();
        ProjectEntity projectEntity = createSampleEntity();

        when(repository.findById(1L)).thenReturn(Optional.of(createSampleEntity()));
        when(projectDtoEntityMapper.convertToEntity(projectDto )).thenReturn(projectEntity);
        when(projectDtoEntityMapper.convertToDto(projectEntity )).thenReturn(projectDto);

        Project retrievedDto = (Project) abstractCrudService.read(1L);

        assertNotNull(retrievedDto);
    }

    @Test
    public void testReadNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchItemFoundException.class, () -> abstractCrudService.read(1L));
        
    }

    @Test
    public void testDelete() {
        abstractCrudService.delete(1L);
        verify(repository, times(1)).deleteById(1L);

    }

    @Test
    public void testReadAll() {
        List<ProjectEntity> projectEntities = createSampleEntities();

        when(repository.findAll()).thenReturn(projectEntities);
        when(mapper.convertToDto(any(ProjectEntity.class))).thenReturn(createSampleDto());

        List<Project> dtoList = abstractCrudService.readAll();

        assertNotNull(dtoList);
        assertTrue(dtoList.isEmpty());
    }

    private Project createSampleDto() {
        Project projectDto = new Project();
        projectDto.setName("project");
        projectDto.setId(1L);
        return projectDto;
    }

    private ProjectEntity createSampleEntity() {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(1L);
        projectEntity.setName("project");
        return projectEntity;
    }

    private List<ProjectEntity> createSampleEntities() {
        return new ArrayList<>();
    }

}

