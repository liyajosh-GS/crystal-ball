package com.project.crystalBall.mapper;

import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.entity.project.ProjectEntity;
import com.project.crystalBall.mapper.project.ProjectDtoEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AbstractDtoEntityMapperTest {

    @InjectMocks
    private AbstractDtoEntityMapper<Project, ProjectEntity> abstractDtoEntityMapper = new ProjectDtoEntityMapper();

    @Mock
    ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToDto() {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName("project");

        Project projectDto = new Project();
        projectDto.setName("project");
        projectDto.setId(1L);

        when(modelMapper.map(projectEntity, Project.class)).thenReturn(projectDto);
        Project result = abstractDtoEntityMapper.convertToDto(projectEntity);

        assertNotNull(result);
        assertEquals(projectDto.getId(), result.getId());
        assertEquals(projectDto.getName(), result.getName());
    }

    @Test
    public void testConvertToEntity() {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName("project");

        Project projectDto = new Project();
        projectDto.setName("project");
        projectDto.setId(1L);

        when(modelMapper.map(projectDto, ProjectEntity.class)).thenReturn(projectEntity);
        ProjectEntity result = abstractDtoEntityMapper.convertToEntity(projectDto);

        assertNotNull(result);
        assertEquals(projectEntity.getId(), projectEntity.getId());
        assertEquals(projectEntity.getName(), projectEntity.getName());
    }


}
