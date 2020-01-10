package com.sonatype.transform.numberstowords.model;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class NumberToWord implements Serializable {

    @NotEmpty
    private String number;
    private String asWord;

    public NumberToWord() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAsWord() {
        return asWord;
    }

    public void setAsWord(String asWord) {
        this.asWord = asWord;
    }

    @Override public String toString() {
        return "NumberToWord{" +
                "number='" + number + '\'' +
                ", asWord='" + asWord + '\'' +
                '}';
    }
}
