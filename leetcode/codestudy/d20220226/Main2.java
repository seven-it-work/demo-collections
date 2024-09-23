/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

package com.huawei.codestudy.d20220226;

import com.huawei.codestudy.d20220226.y30016814.T2y30016814;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * OJ考题代码：删除指定目录
 * NO_AC
 *
 * @author 命题组
 * @since 2021-01-19
 */
public abstract class Main2 {
    // main入口由OJ平台调用
    public static void main(String[] args) {
        Main2 main2 = new T2y30016814();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String delDirNameBunch = cin.nextLine();
        int num = cin.nextInt();
        cin.nextLine();
        String[] dirTreeLines = new String[num];
        for (int i = 0; i < num; i++) {
            dirTreeLines[i] = cin.nextLine();
        }
        cin.close();
        int result = main2.delDirectorys(delDirNameBunch, dirTreeLines);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    public abstract int delDirectorys(String delDirNameBunch, String[] dirTreeLines);

}
