/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220318;

/**
 * 采购系统
 */
public abstract class Main1 {
    public abstract void inventorySystem(int materialsNum, int[][] products);

    public abstract void purchase(int[][] materials);

    public abstract boolean produce(int[] productIds);

    public abstract int queryMin();
}
