package com.viswateja.portfolio.api;

import com.viswateja.portfolio.model.ProjectDtoResponse;
import com.viswateja.portfolio.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController implements  ProjectsApi{

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ResponseEntity<ProjectDtoResponse> getProjects() {
        ProjectDtoResponse response = projectService.getProjects();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
