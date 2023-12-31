package com.project.crystalBall.controller;

import com.project.crystalBall.dto.User.User;
import com.project.crystalBall.dto.project.Project;
import com.project.crystalBall.service.impl.project.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(projectService.read(id));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllLiveProjects(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(projectService.readAllByStatus(Boolean.FALSE));
    }

    @GetMapping("/archived")
    public ResponseEntity<List<Project>> getAllArchivedProjects(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(projectService.readAllByStatus(Boolean.TRUE));
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody @Valid Project project, @AuthenticationPrincipal User user){
        project.setUserId(user.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.create(project));
    }

    @PutMapping
    public ResponseEntity<Project> update(@RequestBody Project project){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.update(project));
    }

}
