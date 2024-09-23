/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

/**
 * #### [223. 矩形面积](https://leetcode-cn.com/problems/rectangle-area/)
 * <p>
 * 难度中等173收藏分享切换为英文接收动态反馈
 * <p>
 * 给你 **二维** 平面上两个 **由直线构成且边与坐标轴平行/垂直** 的矩形，请你计算并返回两个矩形覆盖的总面积。
 * <p>
 * 每个矩形由其 **左下** 顶点和 **右上** 顶点坐标表示：
 * <p>
 * - 第一个矩形由其左下顶点 `(ax1, ay1)` 和右上顶点 `(ax2, ay2)` 定义。
 * - 第二个矩形由其左下顶点 `(bx1, by1)` 和右上顶点 `(bx2, by2)` 定义。
 * <p>
 * <p>
 * <p>
 * **示例 1：**
 * <p>
 * ![Rectangle Area](https://assets.leetcode.com/uploads/2021/05/08/rectangle-plane.png)
 * <p>
 * ```
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * ```
 * <p>
 * **示例 2：**
 * <p>
 * ```
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 * ```
 * <p>
 * <p>
 * <p>
 * **提示：**
 * <p>
 * - `-104 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 104`
 *
 * @author yijialuo
 * @since 2022/3/3 14:33
 */
public class Solution223Date20220303 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaSum = getArea(ax1, ay1, ax2, ay2) + getArea(bx1, by1, bx2, by2);
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        return areaSum - Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);
    }

    private int getArea(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }

    /**
     * 没有AC 换思路
     */
    public int computeArea1(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 矩形全包含
        if (ax1 <= bx1 && ay1 <= by1 && ax2 >= bx2 && ay2 >= by2) {
            return this.getArea(ax1, ay1, ax2, ay2);
        }
        if (ax2 <= bx2 && ay2 <= by2 && ax1 >= bx1 && ay1 >= by1) {
            return this.getArea(bx1, by1, bx2, by2);
        }

        Rectangular rectangularA = new Rectangular(ax1, ay1, ax2, ay2);
        Rectangular rectangularB = new Rectangular(bx1, by1, bx2, by2);
        int[] point1 = rectangularA.findPoint(rectangularB);
        int[] point2 = rectangularB.findPoint(rectangularA);
        int area = rectangularA.getArea() + rectangularB.getArea();
        if (point1 != null && point2 != null) {
            int c = Math.abs(point1[0] - point2[0]);
            int k = Math.abs(point1[1] - point2[1]);
            return area - c * k;
        }
        return area;
    }

    private static class Rectangular {
        private int x1;
        private int y1;
        private int x2;
        private int y2;

        public int getArea() {
            return (Math.abs(x1 - x2)) * (Math.abs(y1 - y2));
        }

        public int[] findPoint(Rectangular rectangular) {
            if (this.isIn(rectangular.x1, rectangular.y1)) {
                // System.out.printf("左下  %s,%s\n", rectangular.x1, rectangular.y1);
                return new int[] {rectangular.x1, rectangular.y1};
            } else if (this.isIn(rectangular.x1, rectangular.y2)) {
                // System.out.printf("左上  %s,%s\n", rectangular.x1, rectangular.y2);
                return new int[] {rectangular.x1, rectangular.y2};
            } else if (this.isIn(rectangular.x2, rectangular.y2)) {
                // System.out.printf("右上  %s,%s\n", rectangular.x2, rectangular.y2);
                return new int[] {rectangular.x2, rectangular.y2};
            } else if (this.isIn(rectangular.x2, rectangular.y1)) {
                // System.out.printf("右下  %s,%s\n", rectangular.x2, rectangular.y1);
                return new int[] {rectangular.x2, rectangular.y1};
            } else {
                return null;
            }
        }

        public Rectangular(int x1, int y1, int x2, int y2) {
            if (x1 > x2) {
                this.x1 = x2;
                this.x2 = x1;
            } else {
                this.x1 = x1;
                this.x2 = x2;
            }
            if (y1 > y2) {
                this.y1 = y2;
                this.y2 = y1;
            } else {
                this.y1 = y1;
                this.y2 = y2;
            }
        }

        private boolean isIn(int x, int y) {
            if (x1 < x && x < x2) {
                return y1 < y && y < y2;
            }
            return false;
        }
    }
}
