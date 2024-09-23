/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.huawei;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @author yijialuo
 * @since 2022/3/4 17:12
 */
public class Oj1808 {
    /**
     * OJ考题代码：整理工号
     * AC
     *
     * @author 命题组
     * @since 2020-3-9
     */
    public static class Main {
        /**
         * main入口由OJ平台调用
         */
        public static void main(String[] args) {
            // Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
            // int num = Integer.parseInt(cin.nextLine());
            // String[] cardIds = new String[num];
            // for (int i = 0; i < num; i++) {
            //     cardIds[i] = cin.nextLine();
            // }
            // cin.close();
            // String[] results = regularID(cardIds);
            // for (String result : results) {
            //     System.out.println(result);
            // }
            System.out.println("12n00".matches(reg));
            System.out.println("ss789".matches(reg));
            System.out.println("k2 3490".matches(reg));
            System.out.println(" k2 3490".matches(reg));
            System.out.println(" m 99 0".matches(reg));
        }

        public static String[] regularID(String[] cardIds) {
            Set<String> result = new HashSet<>();
            for (String id : cardIds) {
                String cardId = id;
                if (cardId.matches(reg)) {
                    // 1.去所有空格
                    cardId = cardId.replace(" ", "");
                    if (cardId.length() > 9) {
                        continue;
                    }
                    // 2.转小写
                    cardId = cardId.toLowerCase(Locale.ROOT);
                    String substring = cardId.substring(1);
                    // 补位
                    int length = substring.length();
                    if (length < 8) {
                        for (int j = 0; j < 8 - length; j++) {
                            substring = "0" + substring;
                        }
                    }
                    result.add(cardId.charAt(0) + substring);
                }
            }
            return result.stream().sorted().toArray(String[]::new);
        }

        static String reg = "[ ]*[a-zA-Z][0-9 ]*";
    }
}
