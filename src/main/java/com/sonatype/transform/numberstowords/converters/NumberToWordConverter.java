package com.sonatype.transform.numberstowords.converters;

import com.google.common.base.Joiner;
import com.sonatype.transform.numberstowords.utils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NumberToWordConverter {

    private final ConvertUtils convertUtils;
    private final BaseNumberToWordConvert baseNumberToWordConvert;

    public NumberToWordConverter(BaseNumberToWordConvert baseNumberToWordConvert, ConvertUtils convertUtils) {
        this.convertUtils = convertUtils;
        this.baseNumberToWordConvert = baseNumberToWordConvert;
    }

    public String convert(int input) {
        boolean isNegativeNumber = input < 0;
        long value = formatInput(input, isNegativeNumber);
        List<String> words = new ArrayList<>();

        List<Integer> chunkNumbers = convertUtils.chunkNumber(value);
        int chunkNumbersSize = chunkNumbers.size();
        for (int i = 0, j = chunkNumbersSize - 1; i < chunkNumbersSize; i++, j--) {
            Integer chunkNumber = chunkNumbers.get(i);
            if (chunkNumber > 0) {
                words.add(baseNumberToWordConvert.convertBaseNumberToWord(chunkNumber, i == chunkNumbersSize - 1));
                words.add(baseNumberToWordConvert.baseForms().get(j));
            }
        }

        return formatOutput(isNegativeNumber, words);
    }

    private long formatInput(int input, boolean isNegativeNumber) {
        long value;
        if (isNegativeNumber) {
            // Special case for Integer.MIN_VALUE
            value = -1L * input;
        } else {
            value = input;
        }
        return value;
    }

    private String formatOutput(boolean isNegativeNumber, List<String> words) {
        if (words.isEmpty()) {
            return isNegativeNumber ? "Negative " + baseNumberToWordConvert.baseNumbers().get(0) :
                    StringUtils.capitalize(baseNumberToWordConvert.baseNumbers().get(0));
        } else {
            return isNegativeNumber ? "Negative " + Joiner.on(" ").join(words).trim() :
                    StringUtils.capitalize(Joiner.on(" ").join(words).trim());
        }
    }
}
