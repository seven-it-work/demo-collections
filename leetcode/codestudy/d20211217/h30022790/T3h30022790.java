/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217.h30022790;

import com.huawei.codestudy.d20211217.T3;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2021-12-30
 */
public class T3h30022790 extends T3 {
    @Override
    public int getMinCollectionTime(int[][] cars) {
        int[] cover = getCover(cars);
        boolean isFound = false;
        for (int i = cover[0]; i <= cover[1]; i++) {
            int coverCarCount = 0;
            // 如果i就是聚点
            for (int[] car : cars) {
                if (canReach(car, cover[2], Integer.compare(i, car[0]), i)) {
                    coverCarCount++;
                } else {  // 该点不是聚点，直接走下一次循环，找新的聚点
                    break;
                }
            }
            if (coverCarCount == cars.length) {  // 存在聚点
                System.out.println("聚合处为：" + i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            return cover[2];
        } else {
            System.out.println("找不到聚点");
            return 0;
        }
    }


    /**
     * 能否到达聚点
     *
     * @param car 车辆信息
     * @param time 时间
     * @param direction 方向 1向右 -1向左 0聚点就是起始位置
     * @param coverPosition 聚点
     * @return 能否到达聚点
     */
    private boolean canReach(int[] car, int time, int direction, int coverPosition) {
        int distance = car[1] * time;  // 速度 * 时间 = 走的距离
        if (direction == 0) {
            return car[1] == 0 || distance % 2 == 0;
        } else {
            int initialPosition = car[0];  // 初始位置
            int farthestPosition = initialPosition + direction * distance;  // 向direction方向最远走到的位置
            int restStep = direction * (farthestPosition - coverPosition);  // 已经走到聚点了，但是还剩下这么多步没走
            // 如果剩余偶数步，那么一定走得回聚点，否则永不可能走到聚点
            return restStep % 2 == 0;
        }
    }

    /**
     * 获取车辆可能经过的最大路径中的最小交集，这里有可能会长循环，直接内存溢出
     * 如果两辆车，一个在Integer.MIN_VALUE，一个在Integer.MAX_VALUE，而它们的速度都为1，那么会循环几十亿次
     * 题目条件没有范围，不清楚这种情况怎么处理
     * 按理说，应该是处理不了的，必须限范围和车辆个数，而且这个范围应该不大才对
     *
     * @param cars 车辆位置与速度信息
     * @return [交集左侧位置，交集右侧位置，形成交集需要的时间]
     */
    private int[] getCover(int[][] cars) {
        int maxLeft = 1;
        int minRight = 0;
        int time = 0;
        while (maxLeft > minRight) {  // 无重合
            time++;
            maxLeft = cars[0][0] - time * cars[0][1];
            minRight = cars[0][0] + time * cars[0][1];
            for (int[] car : cars) {
                maxLeft = Math.max(maxLeft, car[0] - time * car[1]);
                minRight = Math.min(minRight, car[0] + time * car[1]);
            }
        }
        return new int[] {maxLeft, minRight, time};
    }
}
