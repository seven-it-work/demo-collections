/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220121;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-22
 */
public abstract class T1 {

    /**
     * 查询被瓷砖完全覆盖的斜线数
     *
     * @param rows 行数
     * @param cols 列数
     * @param lines 斜线集合
     * @param positions 瓷砖集合
     * @return 完全覆盖的斜线数
     */
    public abstract int getPaintedLineNum(int rows, int cols, int[][] lines, int[][] positions);
}
