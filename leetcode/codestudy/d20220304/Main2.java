/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220304;

import com.huawei.codestudy.d20220304.y30016814.T2y30016814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * OJ考题代码：地震预警通知
 *
 * @author 命题组
 * @since 2021-07-13
 */
public abstract class Main2 {
    // main入口由OJ平台调用
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String[] lineSplit = br.readLine().split(" ");
        int squareSide = Integer.parseInt(lineSplit[0]); // 地图边长
        int gridSide = Integer.parseInt(lineSplit[1]); // 删格边长
        int radius = Integer.parseInt(lineSplit[2]); // 通知半径
        lineSplit = br.readLine().split(" ");
        int yValue = Integer.parseInt(lineSplit[0]); // 地震坐标y值
        int xValue = Integer.parseInt(lineSplit[1]); // 地震坐标x值
        int userCount = Integer.parseInt(br.readLine()); // 用户总数
        int[][] userArray = new int[userCount][];
        for (int idx = 0; idx < userArray.length; idx++) {
            lineSplit = br.readLine().split(" ");
            userArray[idx] = new int[2];
            userArray[idx][0] = Integer.parseInt(lineSplit[0]);
            userArray[idx][1] = Integer.parseInt(lineSplit[1]);
        }
        br.close();
        Earthquake earthquake = new Earthquake(radius, yValue, xValue);
        int[] notify = new T2y30016814().getNotificationOrder(squareSide, gridSide, earthquake, userArray);
        if (notify.length == 0) {
            System.out.print("[]");
        } else {
            System.out.print(Arrays.stream(notify).mapToObj(String::valueOf)
                .collect(Collectors.joining(" ", "[", "]")));
        }
    }

    // 待实现函数，在此函数中填入答题代码
    public abstract int[] getNotificationOrder(int mapSideLen, int gridSideLen, Earthquake earthquake,
        int[][] userArray);

    public static class Earthquake {
        public final int radius;
        public final int rowIdx;
        public final int colIdx;

        Earthquake(int radius, int rowIdx, int colIdx) {
            this.radius = radius;
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
        }
    }
}