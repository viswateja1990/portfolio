package com.viswateja.portfolio.transformer;

import com.viswateja.portfolio.entity.Role;
import com.viswateja.portfolio.model.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mapping(target = "id", expression = "java(String.valueOf(role.getId()))")
    RoleDto toDto(Role role);

    List<RoleDto> toDtoList(List<Role> roles);
}