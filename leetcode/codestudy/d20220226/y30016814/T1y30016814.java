/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220226.y30016814;

import com.huawei.codestudy.d20220226.Main1;

import java.util.Locale;

/**
 * AC
 *
 * @author yijialuo
 * @since 2022/2/25 14:24
 */
public class T1y30016814 extends Main1 {
    @Override
    public String simpleCheckSum(String inputStr) {
        String[] split = inputStr.split(" ");
        String hex01 = null;
        String hex02 = null;
        StringBuilder temp = new StringBuilder();
        for (String str : split) {
            if (temp.length() == 8) {
                if (hex01 == null) {
                    hex01 = temp.toString();
                } else {
                    // 计算
                    hex02 = temp.toString();
                    hex01 = calculation(hex01, hex02);
                }
                temp = new StringBuilder();
            }
            temp.append(str);
        }
        if (temp.length() != 0) {
            temp.append("F".repeat(Math.max(0, 8 - temp.length())));
            if (hex01 == null) {
                return temp.toString();
            } else {
                return calculation(hex01, temp.toString());
            }
        }
        return temp.toString();
    }

    private String calculation(String hex01, String hex02) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hex01.length(); i++) {
            int num1 = Integer.parseInt(hex01.charAt(i) + "", 16);
            int num2 = Integer.parseInt(hex02.charAt(i) + "", 16);
            int result = num1 ^ num2;
            stringBuilder.append(Integer.toHexString(result).toUpperCase(Locale.ROOT));
        }
        return stringBuilder.toString();
    }
}
