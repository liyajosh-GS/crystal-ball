package com.project.crystalBall.controller;

import com.project.crystalBall.dto.User.User;
import com.project.crystalBall.dto.contribution.Contribution;
import com.project.crystalBall.service.impl.contribution.ContributionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContributionControllerTest {

    @InjectMocks
    private ContributionController contributionController;

    @Mock
    private ContributionService contributionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateContribution() {
        Contribution contribution = new Contribution();
        contribution.setId(1L);
        contribution.setAmount(100.0);

        when(contributionService.create(contribution)).thenReturn(contribution);

        ResponseEntity responseEntity = contributionController.create(contribution, new User());

        verify(contributionService, times(1)).create(contribution);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(contribution, responseEntity.getBody());
    }
}

