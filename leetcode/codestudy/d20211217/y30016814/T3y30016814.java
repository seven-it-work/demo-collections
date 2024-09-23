/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217.y30016814;

import com.huawei.codestudy.d20211217.T3;

/**
 * 第三题
 * 不知道对不对哦~
 *
 * @author y30016814
 * @since 2021/12/27 15:16
 */
public class T3y30016814 extends T3 {
    @Override
    public int getMinCollectionTime(int[][] cars) {
        if (cars.length < 2) {
            return 0;
        }
        // 获取最大距离和最小速度
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        int minSpeed = Integer.MAX_VALUE;
        for (int[] car : cars) {
            maxDistance = Math.max(car[0], maxDistance);
            minDistance = Math.min(car[0], minDistance);
            minSpeed = Math.min(car[1], minSpeed);
        }
        // 计算最大花费时间
        int maxTime = (maxDistance - minDistance) / minSpeed;
        int minTime = maxTime / 2;
        while (minTime + 1 < maxTime) {
            if (check(minTime, cars)) {
                maxTime = minTime;
                minTime = minTime / 2;
            } else {
                minTime = (maxTime + minTime) / 2;
            }
        }
        return check(minTime, cars) ? minTime : maxTime;
    }

    private boolean check(int time, int[][] cars) {
        long[] scope = null;
        for (int[] car : cars) {
            long minPoint = car[0] - time * (long) car[1];
            long maxPoint = car[0] + time * (long) car[1];
            if (scope == null) {
                scope = new long[] {minPoint, maxPoint};
            } else {
                if (scope[1] < minPoint) {
                    return false;
                } else {
                    scope[0] = Math.max(minPoint, scope[0]);
                    scope[1] = Math.min(maxPoint, scope[1]);
                }
            }
        }
        return true;
    }

}
