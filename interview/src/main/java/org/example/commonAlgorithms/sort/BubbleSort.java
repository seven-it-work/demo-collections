package org.example.commonAlgorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {20, 40, 30, 10, 60,10, 50};
        for (int i = ints.length - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ints));
    }
}
