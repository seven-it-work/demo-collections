/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217.y30016814;

import com.huawei.codestudy.d20211217.T2;

/**
 * 第二题
 * 感觉要超时
 *
 * @author y30016814
 * @since 2021/12/27 15:02
 */
public class T2y30016814 extends T2 {
    @Override
    public int[] checkConnectivity(int num, int[][] operations) {
        int[] result = new int[num];
        boolean[][] state = new boolean[2][num];
        for (int i = 0; i < operations.length; i++) {
            int[] operation = operations[i];
            // 编号从0开始先
            state[operation[0]][operation[1]] = !state[operation[0]][operation[1]];
            check(state, result, i);
        }
        return result;
    }

    private void check(boolean[][] state, int[] result, int index) {
        boolean isTong = true;
        for (int i = 0; i < result.length; i++) {
            if (state[0][i] && state[1][i]) {
                // 如果主/备用同时 true 不通
                isTong = false;
                break;
            } else if (i < result.length - 1 && state[0][i] && state[1][i + 1]) {
                // 如果主/备+1 同时 true 不通
                isTong = false;
                break;
            } else if (i < result.length - 1 && state[0][i + 1] && state[1][i]) {
                // 如果主+1/备 同时 true 不通
                isTong = false;
                break;
            }
        }
        if (isTong) {
            result[index] = 1;
        }
    }
}
