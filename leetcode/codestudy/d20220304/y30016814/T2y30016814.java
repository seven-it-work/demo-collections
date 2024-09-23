/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220304.y30016814;

import com.huawei.codestudy.d20220304.Main2;

import java.util.ArrayList;

/**
 * @author yijialuo
 * @since 2022/3/11 9:32
 */
public class T2y30016814 extends Main2 {
    private static void alert(Earthquake earthquake, ArrayList<Fences> fencesArrayList, Fences fence) {
        int manH = Math.abs(fence.x - earthquake.colIdx) + Math.abs(fence.y - earthquake.rowIdx);
        if (manH <= earthquake.radius) {
            fence.manH = manH;
            fencesArrayList.add(fence);
        }
    }

    @Override
    public int[] getNotificationOrder(int mapSideLen, int gridSideLen, Earthquake earthquake, int[][] userArray) {
        // 弄一个Fences对象
        Fences[][] build = Fences.build(mapSideLen, gridSideLen, userArray);
        ArrayList<Fences> fencesArrayList = new ArrayList<>();
        // 震源区域
        int xNum = earthquake.colIdx / gridSideLen;
        int yNum = earthquake.rowIdx / gridSideLen;
        int zid = build[yNum][xNum].id;
        // 1.找到地震到每个栅栏的 m距离 并选出合适区域
        for (Fences[] fences : build) {
            for (Fences fence : fences) {
                if (fence.count > 0) {
                    alert(earthquake, fencesArrayList, fence);
                }
            }
        }
        // 2. 排序
        return fencesArrayList.stream().sorted().mapToInt(fences -> fences.id).toArray();
    }

    static class Fences implements Comparable<Fences> {
        private int id;
        private int x;
        private int y;
        private int count;
        private int manH;

        private static Fences[][] build(int mapSideLen, int gridSideLen, int[][] userArray) {
            int size = mapSideLen / gridSideLen;
            Fences[][] fencesMap = new Fences[size][size];
            int mid = (gridSideLen - 1) / 2;
            for (int i = 0; i < size * size; i++) {
                Fences fences = new Fences();
                fences.id = i + 1;
                int tempY = i / size;
                fences.y = gridSideLen * tempY + mid;
                int tempX = i % size;
                fences.x = gridSideLen * tempX + mid;
                fencesMap[tempY][tempX] = fences;
            }
            // 把居民放进栅栏
            for (int[] ints : userArray) {
                int xNum = ints[0] / gridSideLen;
                int yNum = ints[1] / gridSideLen;
                Fences fences = fencesMap[xNum][yNum];
                fences.count++;
            }
            return fencesMap;
        }

        @Override
        public String toString() {
            return "Fences{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", count=" + count +
                ", manH=" + manH +
                '}';
        }

        @Override
        public int compareTo(Fences o) {
            if (o.manH == this.manH) {
                if (o.count == this.count) {
                    return this.id - o.id;
                }
                return o.count - this.count;
            }
            return this.manH - o.manH;
        }
    }
}
