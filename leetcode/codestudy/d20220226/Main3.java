/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2021. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

package com.huawei.codestudy.d20220226;

import com.huawei.codestudy.d20220226.y30016814.T3y30016814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * OJ考题代码
 * 通过！
 *
 * @author 命题组
 * @since 2019-10-22
 */

public abstract class Main3 {
    // main入口由OJ平台调用
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        int appNum = Integer.parseInt(br.readLine());
        int[] appRunTimes = new int[appNum];
        String[] strings = br.readLine().split(" ");
        for (int i = 0; i < appNum; i++) {
            appRunTimes[i] = Integer.parseInt(strings[i]);
        }

        int mutexNum = Integer.parseInt(br.readLine());
        int[][] mutexs = new int[mutexNum][2];
        for (int i = 0; i < mutexNum; i++) {
            strings = br.readLine().split(" ");
            mutexs[i][0] = Integer.parseInt(strings[0]);
            mutexs[i][1] = Integer.parseInt(strings[1]);
        }

        br.close();

        Main3 main3 = new T3y30016814();
        System.out.print(main3.calcRunTime(mutexs, appRunTimes));
    }

    // 待实现函数，在此函数中填入答题代码
    public abstract int calcRunTime(int[][] mutexs, int[] appRunTimes);
}
