package com.project.crystalBall.controller;

import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.dto.project.ProjectPatchContributionsDto;
import com.project.crystalBall.service.impl.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(projectService.readAll());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Project project){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.create(project));
    }

    @PatchMapping("/{id}")
    public ResponseEntity patch(@RequestBody Project project, @PathVariable Long id){
        projectService.patchUpdate(id, project);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PatchMapping("/contributions/{id}")
    public ResponseEntity updateContributions(@RequestBody ProjectPatchContributionsDto contributionsDto, @PathVariable Long id){
        projectService.updateContributions(id, contributionsDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
