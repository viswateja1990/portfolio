package com.viswateja.portfolio.api;

import com.viswateja.portfolio.model.DegreeDtoResponse;
import com.viswateja.portfolio.model.LocationDtoResponse;
import com.viswateja.portfolio.service.DegreeService;
import com.viswateja.portfolio.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController implements  LocationsApi{

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    public ResponseEntity<LocationDtoResponse> getLocations() {
        LocationDtoResponse response = locationService.getLocations();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
