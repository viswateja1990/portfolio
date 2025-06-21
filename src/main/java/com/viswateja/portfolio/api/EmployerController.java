package com.viswateja.portfolio.api;

import com.viswateja.portfolio.model.DegreeDtoResponse;
import com.viswateja.portfolio.model.EmployerDtoResponse;
import com.viswateja.portfolio.service.DegreeService;
import com.viswateja.portfolio.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployerController implements  EmployersApi{

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    public ResponseEntity<EmployerDtoResponse> getEmployers() {
        EmployerDtoResponse response = employerService.getAllEmployers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
