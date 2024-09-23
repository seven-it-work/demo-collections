package com.seven.algorithm.huawei;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Oj1903Test {

    @Test
    @DisplayName("只有数字")
    void case01() {
        String inputStr = "123";
        String except = "123";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

    @Test
    @DisplayName("只有字母")
    void case02() {
        String inputStr = "#123";
        String except = ",ad";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

    @Test
    @DisplayName("只有字母+数字")
    void case03() {
        String inputStr = "123#123";
        String except = "123,ad";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

    @Test
    @DisplayName("一直按数字")
    void case04() {
        String inputStr = "11223312377889";
        String except = "11223312377889";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

    @Test
    @DisplayName("字母+有相同")
    void case05() {
        String inputStr = "#22/23044444411";
        String except = "bad i.";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

    @Test
    @DisplayName("一直按#")
    void case06() {
        String inputStr = "#########################";
        String except = "";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

    @Test
    @DisplayName("一直按#+123")
    void case07() {
        String inputStr = "#########################123";
        String except = ",ad";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

    @Test
    @DisplayName("一直按/")
    void case08() {
        String inputStr = "//////////////";
        String except = "";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

    @Test
    @DisplayName("模拟打字：seven is good. 123")
    void case09() {
        String inputStr = "#77773388833660444777704666/6663110#123";
        String except = "seven is good. 123";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

    @Test
    @DisplayName("连续空格")
    void case010() {
        String inputStr = "#0/0000/0/00/0";
        String except = "         ";
        assertEquals(except, Oj1903.getDisplayString(inputStr));
    }

}