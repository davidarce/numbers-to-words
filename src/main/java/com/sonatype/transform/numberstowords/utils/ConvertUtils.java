package com.sonatype.transform.numberstowords.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ConvertUtils {

    private final int FACTOR = 1000;

    public List<Integer> chunkNumber(Long value) {
        List<Integer> result = new ArrayList<>();

        while (value > 0) {
            result.add((int) (value % FACTOR));
            value = value / FACTOR;
        }

        Collections.reverse(result);
        return result;
    }
}
