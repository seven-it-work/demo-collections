package com.seven.algorithm.huawei;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Oj1808Test {
    @Test
    void case01() {
        String[] cardIds = new String[] {
            "ss789",
            "12n00",
            "s00123",
            "k2 3490",
            "S123",
            "s234",
            "x235",
            "m990",
        };
        String[] except = new String[] {
            "k00023490",
            "m00000990",
            "s00000123",
            "s00000234",
            "x00000235",
        };
        String[] result = Oj1808.Main.regularID(cardIds);
        assertArrayEquals(except, result);
    }

}