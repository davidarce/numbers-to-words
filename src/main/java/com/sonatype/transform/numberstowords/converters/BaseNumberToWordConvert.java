package com.sonatype.transform.numberstowords.converters;

import java.util.Map;

public class BaseNumberToWordConvert {

    private final Map<Integer, String> baseNumbers;
    private final Map<Integer, String> baseForms;

    public BaseNumberToWordConvert(Map<Integer, String> baseNumbers, Map<Integer, String> baseForms) {
        this.baseNumbers = baseNumbers;
        this.baseForms = baseForms;
    }

    public String convertBaseNumberToWord(int value, boolean isLastNumber) {
        if (baseNumbers.containsKey(value)) {
            return baseNumbers.get(value);
        }

        if (value > 20 && value <= 99) {
            int baseTens = (value / 10) * 10;
            int extraTens = value % 10;
            return baseNumbers.get(baseTens) + " " +
                    convertBaseNumberToWord(extraTens, isLastNumber);
        }

        int extraHundreds = value % 100;
        int baseHundreds = value - extraHundreds;
        return baseNumbers.get(baseHundreds) +
                (isLastNumber ? " and " : " ") +
                convertBaseNumberToWord(extraHundreds, isLastNumber);
    }

    public Map<Integer, String> baseForms() {
        return baseForms;
    }

    public Map<Integer, String> baseNumbers() {
        return baseNumbers;
    }
}
