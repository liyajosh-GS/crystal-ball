package com.project.crystalball.service.contribution;

import com.project.crystalball.dto.contribution.Contribution;
import com.project.crystalball.entity.contribution.ContributionEntity;
import com.project.crystalball.entity.project.ProjectEntity;
import com.project.crystalball.exception.NoSuchItemFoundException;
import com.project.crystalball.repository.ContributionRepository;
import com.project.crystalball.repository.ProjectRepository;
import com.project.crystalball.mapper.contribution.ContributionDtoEntityMapper;
import com.project.crystalball.service.impl.contribution.ContributionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContributionServiceTest {

    @Mock
    private ContributionRepository contributionRepository;

    @Mock
    private ContributionDtoEntityMapper contributionDtoEntityMapper;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private JpaRepository repository;

    @InjectMocks
    private ContributionService contributionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateContributionSuccess() {
        Contribution contribution = new Contribution();
        contribution.setProjectId(1L);
        contribution.setAmount(100.0);

        ContributionEntity contributionEntity = new ContributionEntity();
        contributionEntity.setAmount(100.0);

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(1L);
        projectEntity.setCollectedFund(100.0);
        projectEntity.setTargetFund(200.0);
        projectEntity.setIsArchived(false);

        when(contributionDtoEntityMapper.convertToEntity(contribution)).thenReturn(contributionEntity);
        when(projectRepository.findById(1L)).thenReturn(Optional.of(projectEntity));

        Contribution result = contributionService.create(contribution);

        assertEquals(result, contribution);
        assertEquals(200.0, projectEntity.getCollectedFund());
        assertTrue(projectEntity.getIsArchived());
        verify(contributionRepository, times(1)).save(contributionEntity);
        verify(projectRepository, times(1)).save(projectEntity);
    }

    @Test
    public void testCreateContributionProjectNotFound() {
        Contribution contribution = new Contribution();
        contribution.setProjectId(1L);

        when(projectRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchItemFoundException.class, () -> contributionService.create(contribution));
    }

    @Test
    public void testCreateContributionProjectAlreadyArchived() {
        Contribution contribution = new Contribution();
        contribution.setProjectId(1L);

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(1L);
        projectEntity.setIsArchived(true);

        when(projectRepository.findById(1L)).thenReturn(Optional.of(projectEntity));

        assertThrows(RuntimeException.class, () -> contributionService.create(contribution));
    }
}

