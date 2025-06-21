package com.viswateja.portfolio.service.impl;

import com.viswateja.portfolio.entity.Introduction;
import com.viswateja.portfolio.model.IntroductionDto;
import com.viswateja.portfolio.repository.IntroductionRepository;
import com.viswateja.portfolio.service.IntroductionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IntroductionServiceImpl implements IntroductionService {

    private final IntroductionRepository introductionRepository;

    public IntroductionServiceImpl(IntroductionRepository introductionRepository) {
        this.introductionRepository = introductionRepository;
    }

    @Override
    public IntroductionDto getIntroduction() {
        log.info("Fetching introduction");
        IntroductionDto introductionDto = new IntroductionDto();
        introductionDto.setSummary("Welcome to my portfolio!");
        for (Introduction introduction : introductionRepository.findAll()) {
            introductionDto.addPointsItem(introduction.getMessage());
        }
        return introductionDto;
    }
}
