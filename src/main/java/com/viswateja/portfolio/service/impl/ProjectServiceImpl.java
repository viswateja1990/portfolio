package com.viswateja.portfolio.service.impl;

import com.viswateja.portfolio.entity.Project;
import com.viswateja.portfolio.model.ProjectDto;
import com.viswateja.portfolio.model.ProjectDtoResponse;
import com.viswateja.portfolio.repository.ProjectRepository;
import com.viswateja.portfolio.service.ProjectService;
import com.viswateja.portfolio.transformer.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDtoResponse getProjects() {

        List<Project> projects = projectRepository.findAll();
        if (!projects.isEmpty()) {
            ProjectDtoResponse response = new ProjectDtoResponse();
            List<ProjectDto> projectDtos = ProjectMapper.INSTANCE.toDtoList(projects);
            response.setProjects(projectDtos);
            return response;
        }
        return null;
    }
}
