/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203.y30016814;

import com.huawei.codestudy.d20211203.base.BaseT1d20211203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 第一题
 *
 * @author y30016814
 * @since 2021/12/25 16:02
 */
public class T1y30016814 extends BaseT1d20211203 {
    @Override
    public int[] getDeleted(int[][] rectangles, int[] dirtyRectangles) {
        Set<Integer> dirtyIndexList = Arrays.stream(dirtyRectangles).boxed().collect(Collectors.toSet());
        ArrayList<Point> pointList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int x1 = 0;
        int y1 = 0;
        // 1. 先转换为Point对象 x,y(左下角点) x1,y1(右上角点) 并 找到dirty的最大区域
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            if (dirtyIndexList.contains(i)) {
                result.add(i);
                x = Math.min(x, rectangle[0]);
                y = Math.min(y, rectangle[1] - rectangle[3]);
                x1 = Math.max(x1, rectangle[0] + rectangle[2]);
                y1 = Math.max(y1, rectangle[1]);
            } else {
                pointList.add(new Point(rectangle, i));
            }
        }

        // 2. dirty的最大区域构成的point
        Point pointDirty = new Point(x, y, x1, y1);

        // 4. 将非dirtyRectangles的point添加到 集合中并比较
        pointList.forEach(point -> {
            // 注意：这里不用pointDirty.isIn(point) 因为我们判断的是point是否在pointDirty里
            if (point.isIn(pointDirty)) {
                result.add(point.index);
            }
        });
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private static class Point {
        private int index;
        private final int x;
        private final int y;
        private final int x1;
        private final int y1;

        /**
         * 构造,将 rectangles 中的点转换为Point对象
         */
        private Point(int[] rectangle, int index) {
            this.index = index;
            this.x = rectangle[0];
            this.y = rectangle[1] - rectangle[3];
            this.x1 = rectangle[0] + rectangle[2];
            this.y1 = rectangle[1];
        }

        private Point(int x, int y, int x1, int y1) {
            this.x = x;
            this.y = y;
            this.x1 = x1;
            this.y1 = y1;
        }

        /**
         * 3. 写个方法 给你个point 判断是否与这个point有覆盖
         * 判断两个区域是否有交集
         * ((this.y > point.y && this.y < point.y1) || (this.y1 > point.y && this.y1 < point.y1)) (只要y || y1在(point.y,point.y1) 区间就满足)
         * && ((this.x > point.x && this.x < point.x1) || (this.x1 > point.x && this.x1 < point.x1)) (只要x || x1在(point.x,point.x1) 区间就满足)
         *
         * @param point 点
         * @return 判断两个区域是否有交集
         */
        private boolean isIn(Point point) {
            return ((this.y > point.y && this.y < point.y1) || (this.y1 > point.y && this.y1 < point.y1))
                && ((this.x > point.x && this.x < point.x1) || (this.x1 > point.x && this.x1 < point.x1));
        }
    }
}
