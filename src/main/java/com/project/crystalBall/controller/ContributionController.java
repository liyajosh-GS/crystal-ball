package com.project.crystalBall.controller;


import com.project.crystalBall.dto.contribution.Contribution;
import com.project.crystalBall.service.impl.contribution.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contributions")
@CrossOrigin(maxAge = 3600)
public class ContributionController {

    @Autowired
    ContributionService contributionService;

    @PostMapping
    public ResponseEntity create(@RequestBody Contribution contribution){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contributionService.create(contribution));
    }
}
