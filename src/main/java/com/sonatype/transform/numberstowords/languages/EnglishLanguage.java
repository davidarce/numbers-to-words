package com.sonatype.transform.numberstowords.languages;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EnglishLanguage implements Language {

    public EnglishLanguage() {
    }

    @Override
    public Map<Integer, String> baseNumbers() {
        Map<Integer, String> baseNumbers = new HashMap<>();

        baseNumbers.put(0, "zero");
        baseNumbers.put(1, "one");
        baseNumbers.put(2, "two");
        baseNumbers.put(3, "three");
        baseNumbers.put(4, "four");
        baseNumbers.put(5, "five");
        baseNumbers.put(6, "six");
        baseNumbers.put(7, "seven");
        baseNumbers.put(8, "eight");
        baseNumbers.put(9, "nine");
        baseNumbers.put(10, "ten");
        baseNumbers.put(11, "eleven");
        baseNumbers.put(12, "twelve");
        baseNumbers.put(13, "thirteen");
        baseNumbers.put(14, "fourteen");
        baseNumbers.put(15, "fifteen");
        baseNumbers.put(16, "sixteen");
        baseNumbers.put(17, "seventeen");
        baseNumbers.put(18, "eighteen");
        baseNumbers.put(19, "nineteen");
        baseNumbers.put(20, "twenty");
        baseNumbers.put(30, "thirty");
        baseNumbers.put(40, "forty");
        baseNumbers.put(50, "fifty");
        baseNumbers.put(60, "sixty");
        baseNumbers.put(70, "seventy");
        baseNumbers.put(80, "eighty");
        baseNumbers.put(90, "ninety");
        baseNumbers.put(100, "one hundred");
        baseNumbers.put(200, "two hundred");
        baseNumbers.put(300, "three hundred");
        baseNumbers.put(400, "four hundred");
        baseNumbers.put(500, "five hundred");
        baseNumbers.put(600, "six hundred");
        baseNumbers.put(700, "seven hundred");
        baseNumbers.put(800, "eight hundred");
        baseNumbers.put(900, "nine hundred");
        return baseNumbers;
    }

    @Override
    public Map<Integer, String> baseForms() {
        Map<Integer, String> result = new HashMap<>();
        result.put(0, "");
        result.put(1, "thousand");
        result.put(2, "million");
        result.put(3, "billion");
        return result;
    }


}
