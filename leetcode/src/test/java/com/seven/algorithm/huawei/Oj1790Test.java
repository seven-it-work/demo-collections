package com.seven.algorithm.huawei;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Oj1790Test {
    @Test
    void case01() {
        String input = "01-02-03-04-05-06-07";
        int except = 2;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }

    @Test
    void case02() {
        String input = "01:02:03:002-03-04-05-06-07";
        int except = 1;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }

    @Test
    void case03() {
        String input = "0a-0a-0a-0a-0a-0a-0A";
        int except = 1;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }

    @Test
    @DisplayName("大小写重复")
    void case04() {
        String input = "0a-0a-0a-0a-0a-0A-0A";
        int except = 1;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }

    @Test
    @DisplayName("冒号重复")
    void case05() {
        String input = "0a:0a:0a:0a:0a:0A:0A";
        int except = 1;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }

    @Test
    @DisplayName("不满足12位")
    void case06() {
        String input = "0a-0a-0a:0a";
        int except = 1;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }

    @Test
    @DisplayName("满足12位 非16进制")
    void case07() {
        String input = "0a-0b-0c-0d-0f-0g";
        int except = 0;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }

    @Test
    @DisplayName("满足12位 - : 混用")
    void case08() {
        String input = "0a-0b:0c-0d-0f-0a:b1";
        int except = 0;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }

    @Test
    @DisplayName("有超过2个字符")
    void case09() {
        String input = "0a-0b-0c-0df-0f-0a-b1";
        int except = 0;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }

    @Test
    void case010() {
        String input = "00-00-00-00-00-00:00:00:00:00:00:ab:ac:ad";
        int except = 4;
        int result = Oj1790.Main.getMacNum(input);
        assertEquals(except, result);
    }
}