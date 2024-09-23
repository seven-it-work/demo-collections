/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2021. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

package com.huawei.codestudy.d20220226;

import com.huawei.codestudy.d20220226.y30016814.T1y30016814;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * OJ考题代码：校验和
 * NO_AC
 *
 * @author 命题组
 * @since 2020-06-20
 */
public abstract class Main1 {
    // main入口由OJ平台调用
    public static void main(String[] args) {
        Main1 main1 = new T1y30016814();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String inputStr = cin.nextLine();
        cin.close();
        String result = main1.simpleCheckSum(inputStr);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    public abstract String simpleCheckSum(String inputStr);
}
