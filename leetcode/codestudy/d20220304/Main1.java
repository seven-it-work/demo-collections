/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220304;

import com.huawei.codestudy.d20220304.y30016814.T1y30016814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author yijialuo
 * @since 2022/3/4 18:29
 */

/**
 * OJ考题代码：安全又好记的密码
 *
 * @author 命题组
 * @since 2020-4-21
 */
public abstract class Main1 {
    // main入口由OJ平台调用
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String userName = br.readLine();
        String passwordStringPool = br.readLine();
        br.close();
        System.out.print(new T1y30016814().getBestPassword(userName, passwordStringPool));
    }

    // 待实现函数，在此函数中填入答题代码
    public abstract String getBestPassword(String userName, String passwordStringPool);
}
