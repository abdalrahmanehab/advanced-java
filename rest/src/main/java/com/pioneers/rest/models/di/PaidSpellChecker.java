package com.pioneers.rest.models.di;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// beanName = "paidSpellChecker"
@Slf4j
@Service
@Getter
public class PaidSpellChecker implements SpellChecker {

    private final String beanName = "paidSpellChecker";

    private final String owner = "Tech Pioneers Hub";

    public PaidSpellChecker() {
        log.debug("I am in the empty constructor of PaidSpellChecker");
    }
}
