/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220304;

import com.huawei.codestudy.d20220304.y30016814.T3y30016814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public abstract class Main3 {
    // main入口由OJ平台调用
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        int num = Integer.parseInt(br.readLine());
        String[][] routes = new String[num][];
        for (int i = 0; i < num; i++) {
            String[] lineSplit = br.readLine().split(" ");
            int len = Integer.parseInt(lineSplit[0]);
            routes[i] = Arrays.copyOfRange(lineSplit, 1, len + 1);
        }
        String[] lineSplit = br.readLine().split(" ");
        String startSite = lineSplit[0];
        String endSite = lineSplit[1];
        br.close();
        int[] results = new T3y30016814().minRoute(routes, startSite, endSite);
        String[] strResult = Arrays.stream(results).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", strResult));
    }

    // 待实现函数，在此函数中填入答题代码
    public abstract int[] minRoute(String[][] routes, String startSite, String endSite);
}