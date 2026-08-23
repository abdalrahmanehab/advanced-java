package com.pioneers.rest.controllers;

import com.pioneers.rest.models.di.PaidSpellChecker;
import com.pioneers.rest.models.di.TextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("text")
public class TextEditorController {
    // SpellChecker spellChecker = new SpellChecker();
    // TextEditor textEditor = new TextEditor();
    // textEditor.setSpellChecker(spellChecker)
    // TextEditorController textEditorController = new TextEditorController(textEditor);

    private final TextEditor textEditor;

    @Autowired
    public TextEditorController(TextEditor textEditor) {
        System.out.println("I am injecting the TextEditor bean in the TextEditorController");
        this.textEditor = textEditor;
    }

    @GetMapping("find")
    public String findOwnerOfTextEditor() {
        return ((PaidSpellChecker) textEditor.getSpellChecker()).getOwner();
    }
}
