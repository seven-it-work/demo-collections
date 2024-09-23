/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.ArrayList;

/**
 * @author yijialuo
 * @since 2022/3/3 19:40
 */
public class Solution593Date20220303 {

    private boolean isEq(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (isEq(p1, p2) || isEq(p1, p3) || isEq(p1, p4)) {
            return false;
        }
        if (isEq(p2, p3) || isEq(p2, p4)) {
            return false;
        }
        if (isEq(p3, p4)) {
            return false;
        }
        int p1p2 = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        int p1p3 = Math.abs(p1[0] - p3[0]) + Math.abs(p1[1] - p3[1]);
        int p1p4 = Math.abs(p1[0] - p4[0]) + Math.abs(p1[1] - p4[1]);
        int p2p3 = Math.abs(p2[0] - p3[0]) + Math.abs(p2[1] - p3[1]);
        int p2p4 = Math.abs(p2[0] - p4[0]) + Math.abs(p2[1] - p4[1]);
        int p3p4 = Math.abs(p3[0] - p4[0]) + Math.abs(p3[1] - p4[1]);
        if (p1p2 == p1p3 || p1p2 == p1p4 || p1p3 == p1p4) {
            if (p1p2 == p2p3 || p1p2 == p2p4 || p2p3 == p2p4) {
                if (p1p3 == p2p3 || p1p3 == p3p4 || p2p3 == p3p4) {
                    if (p1p4 == p2p4 || p1p4 == p3p4 || p2p4 == p3p4) {
                        ArrayList<int[]> temp = new ArrayList<>();
                        temp.add(p1);
                        temp.add(p2);
                        temp.add(p3);
                        temp.add(p4);
                        for (int[] ints : temp) {
                            int countX = 0;
                            int countY = 0;
                            for (int[] ints1 : temp) {
                                if (ints[0] == ints1[0]) {
                                    countX++;
                                }
                                if (ints[1] == ints1[1]) {
                                    countY++;
                                }
                            }
                            if (countX == 3) {
                                return false;
                            }
                            if (countY == 3) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
