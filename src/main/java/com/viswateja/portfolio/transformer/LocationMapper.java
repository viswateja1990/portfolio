package com.viswateja.portfolio.transformer;

import com.viswateja.portfolio.entity.Location;
import com.viswateja.portfolio.model.LocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    @Mapping(target = "id", expression = "java(String.valueOf(location.getId()))")
    LocationDto toDto(Location location);

    List<LocationDto> toDtoList(List<Location> locations);
}