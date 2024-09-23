package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution904Test {
    @Test
    void test01() {
        int[] fruits = {1, 2, 1};
        Assertions.assertEquals(3, Solution904.totalFruit(fruits));
    }

    @Test
    void test02() {
        int[] fruits = {0, 1, 2, 2};
        Assertions.assertEquals(3, Solution904.totalFruit(fruits));
    }

    @Test
    void test03() {
        int[] fruits = {1, 2, 3, 2, 2};
        Assertions.assertEquals(4, Solution904.totalFruit(fruits));
    }

    @Test
    void test04() {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        Assertions.assertEquals(5, Solution904.totalFruit(fruits));
    }

    @Test
    void test05() {
        int[] fruits = {1, 2, 3, 4, 3, 4, 4};
        Assertions.assertEquals(5, Solution904.totalFruit(fruits));
    }

    @Test
    void test06() {
        int[] fruits = {0, 1, 6, 6, 4, 4, 6};
        Assertions.assertEquals(5, Solution904.totalFruit(fruits));
    }
}