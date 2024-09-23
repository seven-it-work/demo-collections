package com.seven.algorithm.huawei;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Oj1788Test {

    @Test
    void case01() {
        int endPoint = 10;
        int[][] operations = new int[][] {
            {1, 1},
            {2, 1},
            {3, 1},
            {4, -2},
        };
        long expect = 12;
        long result = Oj1788.Main.getMinArea(endPoint, operations);
        assertEquals(expect, result);
    }

    @Test
    void case02() {
        int endPoint = 4;
        int[][] operations = new int[][] {
            {0, 1},
            {2, -2},
        };
        long expect = 4;
        long result = Oj1788.Main.getMinArea(endPoint, operations);
        assertEquals(expect, result);
    }

    @Test
    void case03() {
        int endPoint = 40;
        int[][] operations = new int[][] {
            {0, 0},
            {0, 0},
            {0, 0},
            {0, 0},
        };
        long expect = 0;
        long result = Oj1788.Main.getMinArea(endPoint, operations);
        assertEquals(expect, result);
    }

    @Test
    void case04() {
        int endPoint = 10;
        int[][] operations = new int[][] {
            {1, 1},
            {2, 1},
            {3, 1},
            {4, -3},
        };
        long expect = 6;
        long result = Oj1788.Main.getMinArea(endPoint, operations);
        assertEquals(expect, result);
    }

    @Test
    void case05() {
        int endPoint = 10;
        int[][] operations = new int[][] {
            {1, 1},
            {2, 1},
            {3, 1},
            {4, -4},
        };
        long expect = 12;
        long result = Oj1788.Main.getMinArea(endPoint, operations);
        assertEquals(expect, result);
    }
    @Test
    void case06() {
        int endPoint = 10;
        int[][] operations = new int[][] {
            {1, 1},
            {2, -3},
            {3, 5},
            {4, -2},
        };
        long expect = 12;
        long result = Oj1788.Main.getMinArea(endPoint, operations);
        assertEquals(expect, result);
    }
}