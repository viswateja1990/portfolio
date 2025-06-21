package com.viswateja.portfolio.service.impl;

import com.viswateja.portfolio.entity.Location;
import com.viswateja.portfolio.model.LocationDto;
import com.viswateja.portfolio.model.LocationDtoResponse;
import com.viswateja.portfolio.repository.LocationRepository;
import com.viswateja.portfolio.service.LocationService;
import com.viswateja.portfolio.transformer.LocationMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * @return
     */
    @Override
    public LocationDtoResponse getLocations() {
        List<Location> locations = locationRepository.findAll();
        LocationDtoResponse locationDtoResponse = new LocationDtoResponse();
        List<LocationDto> locationDtos = LocationMapper.INSTANCE.toDtoList(locations);
        locationDtoResponse.setLocations(locationDtos);
        return locationDtoResponse;
    }
}
