package com.viswateja.portfolio.transformer;

import com.viswateja.portfolio.entity.Degree;
import com.viswateja.portfolio.model.DegreeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DegreeMapper {

    DegreeMapper INSTANCE = Mappers.getMapper(DegreeMapper.class);

    @Mapping(target = "id", expression = "java(String.valueOf(degree.getId()))")
    @Mapping(target = "startDate", expression = "java(String.valueOf(degree.getStartDate()))")
    @Mapping(target = "endDate", expression = "java(String.valueOf(degree.getEndDate()))")
    DegreeDto toDto(Degree degree);

    List<DegreeDto> toDtoList(List<Degree> degrees);
}