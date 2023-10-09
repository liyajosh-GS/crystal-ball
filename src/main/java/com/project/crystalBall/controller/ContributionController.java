package com.project.crystalball.controller;


import com.project.crystalball.dto.contribution.Contribution;
import com.project.crystalball.service.impl.contribution.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contributions")
public class ContributionController {

    @Autowired
    ContributionService contributionService;

    @PostMapping
    public ResponseEntity create(@RequestBody Contribution contribution){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contributionService.create(contribution));
    }
}
