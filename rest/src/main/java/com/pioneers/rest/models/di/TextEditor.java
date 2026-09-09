package com.pioneers.rest.models.di;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TextEditor {
//    private final Logger log = LoggerFactory.getLogger(TextEditor.class);
    private SpellChecker spellChecker;

    // Tightly coupled
    public TextEditor() {
        log.debug("I am in the empty constructor of TextEditor");
//        this.spellChecker = new FreeSpellChecker();
    }

    // Loosely coupled
    /*@Autowired
    public TextEditor(SpellChecker spellChecker) {
        System.out.println("I am in the parameterized constructor of TextEditor");
        this.spellChecker = spellChecker;
    }*/

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    @Autowired
    @Qualifier(value = "paidSpellChecker")
    public void setSpellChecker(SpellChecker spellChecker) {
        log.debug("spellChecker.getBeanName() [{}]", spellChecker.getBeanName());
        log.debug("I am in the setSpellChecker");
        this.spellChecker = spellChecker;
    }
}
