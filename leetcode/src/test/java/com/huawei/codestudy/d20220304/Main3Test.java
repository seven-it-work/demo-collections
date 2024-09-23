/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220304;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main3Test extends BaseTest<Main3> {

    public Main3Test() {
        super("com.huawei.codestudy.d20220304", Main3.class);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case01() {
        String[][] routes = new String[][] {
            {"4", "12", "85", "23", "47"},
            {"7", "487", "2655", "85", "1", "23", "2", "3"}
        };
        String startSite = "2655";
        String endSite = "2";
        int[] expect = new int[] {3, 2};
        run(routes, startSite, endSite, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case02() {
        String[][] routes = new String[][] {
            {"8", "1011", "1003", "1007", "1009", "1022", "1018", "1002", "1011"},
            {"4", "1010", "1011", "1026", "1025"},
            {"3", "1026", "1018", "1028"},
        };
        String startSite = "1010";
        String endSite = "1022";
        int[] expect = new int[] {4, 1};
        run(routes, startSite, endSite, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case03() {
        String[][] routes = new String[][] {
            {"2", "12", "47"},
            {"4", "487", "2655", "85", "3333"},
            {"47", "3333"},
        };
        String startSite = "47";
        String endSite = "3333";
        int[] expect = new int[] {-1, -1};
        run(routes, startSite, endSite, expect);
    }

    private void run(String[][] routes, String startSite, String endSite, int[] expect) {
        this.runCore(aClass -> {
            try {
                Main3 main = aClass.newInstance();
                assertArrayEquals(expect, main.minRoute(routes, startSite, endSite));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}