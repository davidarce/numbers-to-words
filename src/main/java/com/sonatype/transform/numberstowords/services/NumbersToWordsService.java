package com.sonatype.transform.numberstowords.services;

import com.sonatype.transform.numberstowords.converters.NumberToWordConverter;
import org.springframework.stereotype.Service;

@Service
public class NumbersToWordsService {

    private final NumberToWordConverter numberToWordConverter;

    public NumbersToWordsService(NumberToWordConverter numberToEnglishWordConverter) {
        this.numberToWordConverter = numberToEnglishWordConverter;
    }

    public String convertNumberToWord(String number) {
        return numberToWordConverter.convert(Integer.parseInt(number));
    }
}
