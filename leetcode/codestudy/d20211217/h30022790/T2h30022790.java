/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217.h30022790;

import com.huawei.codestudy.d20211217.T2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2021-12-30
 */
public class T2h30022790 extends T2 {
    @Override
    public int[] checkConnectivity(int num, int[][] operations) {
        // 定义0为上电，1为下电
        // 实际上，只会有两种情况会出现不连通：相邻两个站点斜对角线设备是1，或者同一站点两个设备是1
        int[][] stations = new int[2][num];
        return Arrays.stream(operations)
            .map(operation -> operateStation(stations, operation))
            .mapToInt(Integer::valueOf).toArray();
    }

    private int operateStation(int[][] stations, int[] operation) {
        stations[operation[0]][operation[1]] = 1 - stations[operation[0]][operation[1]];
        // 遍历列
        return IntStream.range(0, stations[0].length - 1).anyMatch(
            // 存在对角线全为1的情况
            i -> stations[0][i] == 1 && stations[1][i + 1] == 1 || stations[1][i] == 1 && stations[0][i + 1] == 1) ? 0
            // 存在一列全为1的情况
            : IntStream.range(0, stations[0].length).anyMatch(i -> stations[0][i] == 1 && stations[1][i] == 1) ? 0 : 1;
    }
}
