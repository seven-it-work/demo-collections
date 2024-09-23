/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203.base;

/**
 * 2021.12.03专业级科目1第一题
 *
 * @author y30016814
 * @since 2021/12/25 16:01
 */
public abstract class BaseT1d20211203 {
    /**
     * 获取脏区域
     *
     * @param rectangles 矩形
     * @param dirtyRectangles 脏矩形
     * @return 找出与dirty区域有重叠（含部分重叠）的矩形以便重新绘制，并按升序返回这些矩形编号的序列；若无重叠的矩形，则返回空序列[]
     */
    public abstract int[] getDeleted(int[][] rectangles, int[] dirtyRectangles);
}
