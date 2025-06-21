package com.viswateja.portfolio.api;

import com.viswateja.portfolio.model.DegreeDtoResponse;
import com.viswateja.portfolio.model.ProjectDtoResponse;
import com.viswateja.portfolio.service.DegreeService;
import com.viswateja.portfolio.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DegreeController implements  DegreesApi{

    private final DegreeService degreeService;

    public DegreeController(DegreeService degreeService) {
        this.degreeService = degreeService;
    }

    public ResponseEntity<DegreeDtoResponse> getDegrees() {
        DegreeDtoResponse response = degreeService.getDegrees();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
