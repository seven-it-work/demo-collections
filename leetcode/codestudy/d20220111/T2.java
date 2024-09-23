/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220111;

/**
 * 2022.1.11 专业级科目1练习第二题
 *
 * @author y00375357
 * @since 2022/1/12
 */
public abstract class T2 {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额
     *
     * @param nums 可偷取金额
     * @return 是否还连通，连通则返回1，不连通则返回0
     */
    public abstract int rob(int[] nums);
}
