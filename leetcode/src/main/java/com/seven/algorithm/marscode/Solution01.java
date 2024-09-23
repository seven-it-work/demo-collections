package com.seven.algorithm.marscode;

/**
 * https://www.marscode.cn/practice/dnko3lqxl0o65d
 * 一般
 * 题目都看不懂
 */
public class Solution01 {

    public static String solution(int num, String data) {
        // Please write your code here
        return "-2";
    }

    public static void main(String[] args) {
        //  You can add more test cases here
        System.out.println(solution(14, ".L.R...LR..L..").equals("4:3,6,13,14"));
        System.out.println(solution(5, "R....").equals("0"));
        System.out.println(solution(1, ".").equals("1:1"));
    }
}
