package com.viswateja.portfolio.service;

import com.viswateja.portfolio.model.ProjectDtoResponse;

public interface ProjectService {

    /**
     * Retrieves a list of projects.
     *
     * @return a list of ProjectDtoResponse objects representing the projects.
     */
    ProjectDtoResponse getProjects();
}
