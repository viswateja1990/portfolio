package com.viswateja.portfolio.service.impl;

import com.viswateja.portfolio.entity.Degree;
import com.viswateja.portfolio.model.DegreeDto;
import com.viswateja.portfolio.model.DegreeDtoResponse;
import com.viswateja.portfolio.repository.DegreeRepository;
import com.viswateja.portfolio.service.DegreeService;
import com.viswateja.portfolio.transformer.DegreeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeServiceImpl implements DegreeService {

    private final DegreeRepository degreeRepository;

    public DegreeServiceImpl(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    /**
     * @return
     */
    @Override
    public DegreeDtoResponse getDegrees() {
        List<Degree> degrees = degreeRepository.findAll();
        List<DegreeDto> degreeDtos =  DegreeMapper.INSTANCE.toDtoList(degrees);
        if (!degreeDtos.isEmpty()) {
            DegreeDtoResponse degreeDtoResponse = new DegreeDtoResponse();
            degreeDtoResponse.setDegrees(degreeDtos);
            return degreeDtoResponse;
        }
        return null;
    }
}
