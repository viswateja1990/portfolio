package com.viswateja.portfolio.api;

import com.viswateja.portfolio.model.ProjectDtoResponse;
import com.viswateja.portfolio.model.RoleDtoResponse;
import com.viswateja.portfolio.service.ProjectService;
import com.viswateja.portfolio.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController implements  RolesApi{

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    public ResponseEntity<RoleDtoResponse> getRoles() {
        RoleDtoResponse response = roleService.getAllRoles();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
