/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220304.y30016814;

import com.huawei.codestudy.d20220304.Main1;

import java.util.HashSet;

/**
 * @author yijialuo
 * @since 2022/3/11 9:31
 */
public class T1y30016814 extends Main1 {

    static String reg1 = ".*[A-Z].*";
    static String reg2 = ".*[a-z0-9].*";
    static String reg3 = ".*[.!@#$%].*";

    @Override
    public String getBestPassword(String userName, String passwordStringPool) {
        if (passwordStringPool.length() < 6) {
            return "empty";
        }
        HashSet<String> strings = new HashSet<>();
        for (int len = 6; len <= 12; len++) {
            for (int i = 0; i <= passwordStringPool.length() - len; i++) {
                String substring = passwordStringPool.substring(i, i + len);
                checkAndAdd(userName, strings, substring);
            }
        }
        if (!strings.isEmpty()) {
            return strings.stream().sorted().findFirst().get();
        }
        return "empty";
    }

    private void checkAndAdd(String userName, HashSet<String> strings, String substring) {
        if (substring.matches(reg1) &&
            substring.matches(reg2) &&
            substring.matches(reg3)) {
            if (!substring.contains(userName)) {
                strings.add(substring);
            }
        }
    }
}
