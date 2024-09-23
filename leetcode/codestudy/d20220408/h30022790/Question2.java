/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220408.h30022790;

import com.huawei.codestudy.d20220408.Main2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Question2 extends Main2 {
    @Override
    public int[] getClosestPositions(int[][] positions, int num) {
        int[][] temps = new int[positions.length][2];
        IntStream.range(0, positions.length).forEach(i -> {
            temps[i][0] = i;
            temps[i][1] = positions[i][0] * positions[i][0] + positions[i][1] * positions[i][1];
        });
        Arrays.sort(temps, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        // 按升序返回离中心最近的num个坐标点的下标
        return IntStream.range(0, num).map(i -> temps[i][0]).sorted().toArray();
    }
}
