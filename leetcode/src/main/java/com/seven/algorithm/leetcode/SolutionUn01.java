/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author yijialuo
 * @since 2022/6/30 9:03
 */
public class SolutionUn01 {
    static final int Squared = 2;

    public static void main(String[] args) {
        demo02();
    }

    public static int[] getMinDistances(int[][] position, int num) {
        final ArrayList<Sqrt> sqrtArrayList = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            sqrtArrayList.add(new Sqrt(position[i], i));
        }
        return sqrtArrayList.stream()
            .sorted()
            .collect(Collectors.toList())
            .subList(0, num)
            .stream()
            .mapToInt(sqrt -> sqrt.index)
            .sorted()
            .toArray();
    }
    private static class Sqrt implements Comparable<Sqrt> {
        private final int index;

        private final double powValue;

        public Sqrt(int[] ints, int index) {
            this.index = index;
            powValue = Math.pow(ints[0], Squared) + Math.pow(ints[1], Squared);
        }

        @Override
        public int compareTo(Sqrt o) {
            return (int) (powValue - o.powValue);
        }
    }



    private static void demo01() {
        final int[][] ints = new int[][] {
            {1, 3},
            {-2, 2}
        };
        final int[] minDistances = getMinDistances(ints, 1);
        System.out.println(Arrays.toString(minDistances));
    }

    private static void demo02() {
        final int[][] ints = new int[][] {
            {5, -1},
            {-2, 4},
            {3, 3},
        };
        final int[] minDistances = getMinDistances(ints, 2);
        System.out.println(Arrays.toString(minDistances));
    }

}
