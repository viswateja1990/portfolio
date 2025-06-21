package com.viswateja.portfolio.transformer;

import com.viswateja.portfolio.entity.Project;
import com.viswateja.portfolio.model.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(target = "id", expression = "java(String.valueOf(project.getId()))")
    @Mapping(target = "startDate", expression = "java(String.valueOf(project.getStartDate()))")
    @Mapping(target = "endDate", expression = "java(String.valueOf(project.getEndDate()))")
    ProjectDto toDto(Project project);

    List<ProjectDto> toDtoList(List<Project> projects);
}