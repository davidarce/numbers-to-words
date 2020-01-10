package com.sonatype.transform.numberstowords.controller;

import com.sonatype.transform.numberstowords.model.NumberToWord;
import com.sonatype.transform.numberstowords.services.NumbersToWordsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("numberToWord")
public class NumbersToWordsController {

    private final NumbersToWordsService numbersToWordsService;

    public NumbersToWordsController(NumbersToWordsService numbersToWordsService) {
        this.numbersToWordsService = numbersToWordsService;
    }

    @GetMapping(value = {"/convert", "/"})
    public String homePage(Model model) {
        NumberToWord numberToWord = new NumberToWord();
        model.addAttribute("numberToWord", numberToWord);
        return "home";
    }

    @PostMapping("/convert")
    public String convertNumber(@Valid NumberToWord numberToWord, Model model,
            BindingResult result, RedirectAttributes flash) {

        if (result.hasErrors()) {
            return "convert";
        } else {
            try {
                numberToWord.setAsWord(numbersToWordsService.convertNumberToWord(numberToWord.getNumber()));
            } catch (Exception e) {
                flash.addFlashAttribute("error",
                        "Invalid number, enter a number between –2,147,483,648 and 2,147,483,647");
                return "redirect:/convert";
            }
        }
        return "home";
    }
}
