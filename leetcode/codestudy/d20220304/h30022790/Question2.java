/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220304.h30022790;

import com.huawei.codestudy.d20220304.Main2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question2 extends Main2 {
    @Override
    public int[] getNotificationOrder(int mapSideLen, int gridSideLen, Earthquake earthquake, int[][] userArray) {
        List<int[]> gridUserList = Arrays.stream(userArray)
            .filter(people ->
                getDistance(getGridCenter(people, mapSideLen, gridSideLen), earthquake.rowIdx, earthquake.colIdx)
                    <= earthquake.radius)
            .collect(Collectors.toList());
        if (gridUserList.size() == 0) {
            return new int[] {};
        }
        Map<Integer, Integer> map = new HashMap<>();
        gridUserList.stream()
            .mapToInt(people -> getGridNo(people, mapSideLen, gridSideLen))
            .forEach(gridNo -> map.merge(gridNo, 1, Integer::sum));
        // int[] 0 栅格中用户数 1 栅格编号
        List<int[]> selectUserList = map.entrySet()
            .stream()
            .map(next -> new int[] {next.getValue(), next.getKey()})
            .sorted((o1, o2) -> {
                int[] p1 = getGridCenter(o1[1], mapSideLen, gridSideLen);
                int[] p2 = getGridCenter(o2[1], mapSideLen, gridSideLen);
                int d1 = getDistance(p1, earthquake.rowIdx, earthquake.colIdx);
                int d2 = getDistance(p2, earthquake.rowIdx, earthquake.colIdx);
                return d1 == d2 ? (o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]) : d1 - d2;
            }).collect(Collectors.toList());
        return selectUserList.stream().mapToInt(ints -> ints[1]).toArray();
    }

    private int getGridNo(int[] people, int mapSideLen, int gridSideLen) {
        int row = people[0];
        int col = people[1];
        int gridRow = row / gridSideLen;
        int gridCol = col / gridSideLen;
        return gridRow * (mapSideLen / gridSideLen) + gridCol + 1;
    }

    private int[] getGridCenter(int gridNo, int mapSideLen, int gridSideLen) {
        int gridNumPerRow = mapSideLen / gridSideLen;
        int rowNo = (gridNo - 1) / gridNumPerRow;
        int colNo = (gridNo - 1) % gridNumPerRow;
        int centerRow = rowNo * gridSideLen + gridSideLen / 2;
        int centerCol = colNo * gridSideLen + gridSideLen / 2;
        return new int[] {centerRow, centerCol};
    }

    private int[] getGridCenter(int[] people, int mapSideLen, int gridSideLen) {
        return getGridCenter(getGridNo(people, mapSideLen, gridSideLen), mapSideLen, gridSideLen);
    }

    private int getDistance(int[] point1, int x, int y) {
        return Math.abs(point1[0] - x) + Math.abs(point1[1] - y);
    }
}
