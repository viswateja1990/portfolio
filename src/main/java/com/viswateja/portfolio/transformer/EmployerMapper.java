package com.viswateja.portfolio.transformer;

import com.viswateja.portfolio.entity.Employer;
import com.viswateja.portfolio.model.EmployerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployerMapper {
    EmployerMapper INSTANCE = Mappers.getMapper(EmployerMapper.class);

    @Mapping(target = "id", expression = "java(String.valueOf(employer.getId()))")
    @Mapping(target = "startDate", expression = "java(String.valueOf(employer.getStartDate()))")
    @Mapping(target = "endDate", expression = "java(String.valueOf(employer.getEndDate()))")
    EmployerDto toDto(Employer employer);

    List<EmployerDto> toDtoList(List<Employer> employers);
}