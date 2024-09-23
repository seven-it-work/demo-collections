/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220304;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OJ考题代码：地震预警通知
 *
 * @author 命题组
 * @since 2021-07-13
 */

public class AC02 {

    // 待实现函数，在此函数中填入答题代码

    static int[] getNotificationOrder(int mapSideLen, int gridSideLen, Main2.Earthquake earthquake, int[][] userArray) {
        int num = mapSideLen / gridSideLen;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : userArray) {
            int x_num = ints[0];
            int y_num = ints[1];
            int grid_num = (x_num / gridSideLen) * num + y_num / gridSideLen + 1;
            map.put(grid_num, map.getOrDefault(grid_num, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet()) {
            int grid_x = ((key - 1) / num) * gridSideLen + gridSideLen / 2;
            int grid_y = (key - 1) % num * gridSideLen + gridSideLen / 2;
            int dis = Math.abs(earthquake.rowIdx - grid_x) + Math.abs(earthquake.colIdx - grid_y);
            if (dis <= earthquake.radius) {
                list.add(new int[] {dis, map.get(key), key});
            }
        }
        if (list.size() == 0) {
            return new int[] {};
        }
        list.sort((o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                if (o1[1] > o2[1]) {
                    return -1;
                } else if (o1[1] < o2[1]) {
                    return 1;
                } else {
                    return Integer.compare(o1[2], o2[2]);
                }
            }
        });
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i)[2];
        }
        return res;
    }

}