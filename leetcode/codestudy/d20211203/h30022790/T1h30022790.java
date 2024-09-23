/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203.h30022790;

import com.huawei.codestudy.d20211203.base.BaseT1d20211203;

import java.util.stream.IntStream;

/**
 * 找dirty区域
 *
 * @author h30022790
 * @since 2021-12-27
 */
public class T1h30022790 extends BaseT1d20211203 {
    @Override
    public int[] getDeleted(int[][] rectangles, int[] dirtyRectangles) {
        if (rectangles == null || rectangles.length == 0 || dirtyRectangles == null || dirtyRectangles.length == 0) {
            return new int[] {};
        }
        int[] dirtyWrap = getDirtyWrapCoordinate(rectangles, dirtyRectangles);
        return IntStream.range(0, rectangles.length)
            .filter(index ->
                getRightX(rectangles[index]) > dirtyWrap[0] && getLeftX(rectangles[index]) < dirtyWrap[1]
                && getTopY(rectangles[index]) > dirtyWrap[2] && getBottomY(rectangles[index]) < dirtyWrap[3])
            .toArray();
    }

    private int[] getDirtyWrapCoordinate(int[][] rectangles, int[] dirty) {
        int dirtyLx = getLeftX(rectangles[dirty[0]]);
        int dirtyRx = getRightX(rectangles[dirty[0]]);
        int dirtyBy = getBottomY(rectangles[dirty[0]]);
        int dirtyTy = getTopY(rectangles[dirty[0]]);
        for (int index : dirty) {
            dirtyLx = Math.min(dirtyLx, getLeftX(rectangles[index]));
            dirtyRx = Math.max(dirtyRx, getRightX(rectangles[index]));
            dirtyBy = Math.min(dirtyBy, getBottomY(rectangles[index]));
            dirtyTy = Math.max(dirtyTy, getTopY(rectangles[index]));
        }
        return new int[] {dirtyLx, dirtyRx, dirtyBy, dirtyTy};
    }

    private int getLeftX(int[] rectangle) {
        return rectangle[0];
    }

    private int getRightX(int[] rectangle) {
        return rectangle[0] + rectangle[2];
    }

    private int getBottomY(int[] rectangle) {
        return rectangle[1] - rectangle[3];
    }

    private int getTopY(int[] rectangle) {
        return rectangle[1];
    }
}
