/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220408;

public abstract class Main3 {
    public abstract void initSkiRankingSystem();

    public abstract void addRecord(int userId, int duration);

    public abstract int[] getTopAthletes(int num);

    public abstract int[] queryTop3Record(int userId);
}
