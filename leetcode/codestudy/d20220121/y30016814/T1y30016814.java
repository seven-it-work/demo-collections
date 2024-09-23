/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220121.y30016814;

import com.huawei.codestudy.d20220121.T1;

/**
 * @author y30016814
 * @since 2022/1/29 17:36
 */
public class T1y30016814 extends T1 {
    @Override
    public int getPaintedLineNum(int rows, int cols, int[][] lines, int[][] positions) {
        boolean[][] maps = new boolean[rows][cols];
        for (int[] position : positions) {
            maps[position[0]][position[1]] = true;
        }
        int count = 0;
        for (int[] line : lines) {
            // 检测是否覆盖
            if (this.determineTheDirection(maps, line[0], line[1], line[2], line[3])) {
                count++;
            }
        }
        return count;
    }

    private boolean determineTheDirection(boolean[][] arr, int x, int y, int endX, int endY) {
        // 0,0在左上角的坐标系
        if (x < endX && y < endY) {
            // 左上角->右下角
            return !leftUp2RightDown(arr, x, y, endX);
        } else if (x > endX && y > endY) {
            // 右下角->左上角
            return !rightDown2leftUp(arr, x, y, endX);
        } else if (x < endX && y > endY) {
            // 右上角->左下角
            return rightUp2LeftDown(arr, x, y, endX);
        } else if (x > endX && y < endY) {
            // 左下角->右上角
            return rightUp2LeftDown(arr, endX, endY, x);
        } else if (x == endX && y != endY) {
            // 同一x
            return !checkInX(arr, x, y, endY);
        } else if (x != endX) {
            // 同一y
            return !checkInY(arr, x, y, endX);
        } else {
            // 一个点
            return arr[x][y];
        }
    }

    /**
     * 同一y坐标
     */
    private boolean checkInY(boolean[][] arr, int x, int y, int endX) {
        for (int i = Math.min(x, endX); i <= Math.max(x, endX); i++) {
            if (!arr[i][y]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 同一x坐标
     */
    private boolean checkInX(boolean[][] arr, int x, int y, int endY) {
        for (int i = Math.min(y, endY); i <= Math.max(y, endY); i++) {
            if (!arr[x][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean rightUp2LeftDown(boolean[][] arr, int x, int y, int endX) {
        for (int i = x; i <= endX; i++) {
            if (!arr[i][y - (i - x)]) {
                return false;
            }
        }
        return true;
    }

    private boolean rightDown2leftUp(boolean[][] arr, int x, int y, int endX) {
        for (int i = x; i >= endX; i--) {
            if (!arr[i][y - (x - i)]) {
                return true;
            }
        }
        return false;
    }

    private boolean leftUp2RightDown(boolean[][] arr, int x, int y, int endX) {
        for (int i = x; i <= endX; i++) {
            if (!arr[i][y + (i - x)]) {
                return true;
            }
        }
        return false;
    }
}
