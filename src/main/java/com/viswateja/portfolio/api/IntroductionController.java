package com.viswateja.portfolio.api;

import com.viswateja.portfolio.model.IntroductionDto;
import com.viswateja.portfolio.service.IntroductionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IntroductionController implements IntroductionApi {

    private final IntroductionService introductionService;

    public IntroductionController(IntroductionService introductionService) {
        this.introductionService = introductionService;
    }

    public ResponseEntity<IntroductionDto> getIntroduction() {
        log.info("Handling request for introduction");
        IntroductionDto response = introductionService.getIntroduction();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
