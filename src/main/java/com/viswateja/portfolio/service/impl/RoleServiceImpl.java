package com.viswateja.portfolio.service.impl;

import com.viswateja.portfolio.entity.Role;
import com.viswateja.portfolio.model.RoleDto;
import com.viswateja.portfolio.model.RoleDtoResponse;
import com.viswateja.portfolio.repository.RoleRepository;
import com.viswateja.portfolio.service.RoleService;
import com.viswateja.portfolio.transformer.RoleMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoleDtoResponse getAllRoles() {
        List<Role> roles = repository.findAll();
        List<RoleDto> roleDtos = RoleMapper.INSTANCE.toDtoList(roles);
        RoleDtoResponse roleDtoResponse = new RoleDtoResponse();
        roleDtoResponse.setRoles(roleDtos);
        return roleDtoResponse;
    }
}
