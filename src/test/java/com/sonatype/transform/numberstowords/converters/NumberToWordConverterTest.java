package com.sonatype.transform.numberstowords.converters;

import com.sonatype.transform.numberstowords.languages.EnglishLanguage;
import com.sonatype.transform.numberstowords.languages.Language;
import com.sonatype.transform.numberstowords.utils.ConvertUtils;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberToWordConverterTest {

    private NumberToWordConverter numberToWordConverter;

    @Before
    public void setUp() {
        Language englishLanguage = new EnglishLanguage();
        BaseNumberToWordConvert baseNumberToWordConvert = new BaseNumberToWordConvert(
                englishLanguage.baseNumbers(), englishLanguage.baseForms());
        ConvertUtils convertUtils = new ConvertUtils();
        numberToWordConverter = new NumberToWordConverter(baseNumberToWordConvert, convertUtils);
    }

    @Test
    public void shouldCanConvertNumber() {
        numberToWordConverter.convert(0);
    }

    @Test
    public void shouldConvertNumberZeroToWordEquivalent() {
        assertThat(numberToWordConverter.convert(0), is("Zero"));
    }

    @Test
    public void shouldConvertBaseNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(10), is("Ten"));
    }

    @Test
    public void shouldConvertComplexTwoDigitsNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(85), is("Eighty five"));
    }

    @Test
    public void shouldConvertComplexThreeDigitsNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(206), is("Two hundred and six"));
    }

    @Test
    public void shouldConvertComplexFourDigitsNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(5_237), is("Five thousand two hundred and thirty seven"));
    }

    @Test
    public void shouldConvertComplexHundredThousandNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(100_582), is("One hundred thousand five hundred and eighty two"));
    }

    @Test
    public void shouldConvertMillionNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(1_000_000), is("One million"));
    }

    @Test
    public void shouldConvertComplexMillionNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(1_001_000), is("One million one thousand"));
    }

    @Test
    public void shouldConvertBillionNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(1_000_000_000), is("One billion"));
    }

    @Test
    public void shouldConvertComplexBillionNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(Integer.MAX_VALUE), is("Two billion one hundred forty seven million four hundred eighty three thousand six hundred and forty seven"));
    }

    @Test
    public void shouldConvertNegativeNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(-10), is("Negative ten"));
    }

    @Test
    public void shouldConvertIntegerMinValueNumberToWordsEquivalent() {
        assertThat(numberToWordConverter.convert(Integer.MIN_VALUE), is("Negative two billion one hundred forty seven million four hundred eighty three thousand six hundred and forty eight"));
    }
}
