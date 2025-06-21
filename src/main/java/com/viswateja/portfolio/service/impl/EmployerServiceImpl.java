package com.viswateja.portfolio.service.impl;

import com.viswateja.portfolio.entity.Employer;
import com.viswateja.portfolio.model.EmployerDto;
import com.viswateja.portfolio.model.EmployerDtoResponse;
import com.viswateja.portfolio.repository.EmployerRepository;
import com.viswateja.portfolio.service.EmployerService;
import com.viswateja.portfolio.transformer.EmployerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    /**
     * @return
     */
    @Override
    public EmployerDtoResponse getAllEmployers() {
        List<Employer> employerList = employerRepository.findAll();
        List<EmployerDto> employerDtos = EmployerMapper.INSTANCE.toDtoList(employerList);
        EmployerDtoResponse employerDtoResponse = new EmployerDtoResponse();
        employerDtoResponse.setEmployers(employerDtos);
        return employerDtoResponse;
    }
}
