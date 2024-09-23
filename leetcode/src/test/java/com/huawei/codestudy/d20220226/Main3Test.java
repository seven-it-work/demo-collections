/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220226;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main3Test extends BaseTest<Main3> {

    public Main3Test() {
        super("com.huawei.codestudy.d20220226", Main3.class);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case01() {
        int[][] mutexs = new int[][] {{1, 2}};
        int[] appRunTimes = new int[] {1, 2, 10};
        int expect = 11;
        run(mutexs, appRunTimes, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case02() {
        int[][] mutexs = new int[][] {{0}};
        int[] appRunTimes = new int[] {1};
        int expect = 1;
        run(mutexs, appRunTimes, expect);
    }

    private void run(int[][] mutexs, int[] appRunTimes, int expect) {
        this.runCore(aClass -> {
            try {
                Main3 main3 = aClass.newInstance();
                assertEquals(expect, main3.calcRunTime(mutexs, appRunTimes));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}