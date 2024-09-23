/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220408.y30016814;

import com.huawei.codestudy.d20220408.Main2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 耗时17分钟
 *
 * @author yijialuo
 * @since 2022/4/24 10:00
 */
public class Main2Y30016814 extends Main2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Main2Y30016814().getClosestPositions(
            new int[][] {
                {1, 3},
                {-2, 2}
            }, 1)));
        System.out.println(Arrays.toString(new Main2Y30016814().getClosestPositions(
            new int[][] {
                {3, 3}, {5, -1}, {-2, 4}
            }, 2)));
    }

    @Override
    public int[] getClosestPositions(int[][] positions, int num) {
        HashMap<Integer, Long> indexAndValue = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            indexAndValue.put(i, (long) positions[i][1] * positions[i][1] + (long) positions[i][0] * positions[i][0]);
        }
        return indexAndValue.entrySet()
            .stream()
            .sorted(Comparator.comparing(Map.Entry::getValue))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList())
            .subList(0, num)
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
