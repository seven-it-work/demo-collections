/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217;

/**
 * 2021.12.17专业级科目1第二题
 *
 * @author y30016814
 * @since 2021/12/27 14:21
 */
public abstract class T2 {
    /**
     * 测试连通性
     *
     * @param num 站点数量
     * @param operations 操作一个二维数组，[[设备标识，站点编号]]， 设备标识为0，标识主设备，设备表示为1，表示备设备
     * @return 是否还连通，连通则返回1，不连通则返回0
     */
    public abstract int[] checkConnectivity(int num, int[][] operations);
}
