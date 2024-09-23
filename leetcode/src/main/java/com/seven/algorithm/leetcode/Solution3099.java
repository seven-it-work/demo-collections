package com.seven.algorithm.leetcode;

public class Solution3099 {
    public static void main(String[] args) {
        System.out.println(new Solution3099().sumOfTheDigitsOfHarshadNumber2(18));
    }

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        String[] split = (x + "").split("");
        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        return x % sum == 0 ? sum : -1;
    }

    public int sumOfTheDigitsOfHarshadNumber2(int x) {
        if (x <= 0) {
            return -1;
        }
        int tempX = x;
        int sum = 0;
        while (tempX > 0) {
            int data = tempX % 10;
            sum += data;
            tempX -= data;
            tempX = tempX / 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}
