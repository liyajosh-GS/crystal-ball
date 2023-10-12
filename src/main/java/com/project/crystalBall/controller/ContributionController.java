package com.project.crystalBall.controller;


import com.project.crystalBall.dto.User.User;
import com.project.crystalBall.dto.contribution.Contribution;
import com.project.crystalBall.service.impl.contribution.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contributions")
public class ContributionController {

    @Autowired
    ContributionService contributionService;

    @PostMapping
    public ResponseEntity<Contribution> create(@RequestBody Contribution contribution, @AuthenticationPrincipal User user){
        contribution.setUserId(user.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contributionService.create(contribution));
    }
}
