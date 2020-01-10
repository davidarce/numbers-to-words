package com.sonatype.transform.numberstowords.languages;

import java.util.Map;

public interface Language {

    Map<Integer, String> baseNumbers();
    Map<Integer, String> baseForms();
}
