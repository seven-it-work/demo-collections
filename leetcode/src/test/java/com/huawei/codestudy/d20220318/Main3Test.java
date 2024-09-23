/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220318;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main3Test extends BaseTest<Main3> {

    public Main3Test() {
        super("com.huawei.codestudy.d20220318", Main3.class);
    }

    @Test
    void case01() {
        this.run(new int[][] {{1, 4}, {3, 4}}, new int[] {3, 4}, 2);
    }

    @Test
    void case02() {
        this.run(new int[][] {{3, 6}, {5, 5}, {1, 4}, {3, 4}}, new int[] {5, 3, 4}, 3);
    }

    @Test
    void case03() {
        this.run(new int[][] {{3, 6}, {3, 4}, {9, 10}, {5, 5}, {1, 4}, {3, 4}}, new int[] {5, 8, 3, 4}, 3);
    }

    @Test
    void case04() {
        this.run(new int[][] {{3, 6}, {3, 4}, {9, 10}, {5, 5}, {1, 4}, {3, 4}}, new int[] {5, 8, 4}, 2);
    }

    @Test
    void case05() {
        this.run(new int[][] {{2, 4}, {5, 6}}, new int[] {1}, 0);
    }

    @Test
    void case06() {
        this.run(new int[][] {{2, 4}, {5, 6}}, new int[] {1}, 0);
    }

    @Test
    void case07() {
        this.run(new int[][] {}, new int[] {}, 0);
    }

    @Test
    void case08() {
        this.run(new int[][] {}, new int[] {1}, 0);
    }

    @Test
    void case09() {
        this.run(new int[][] {{1, 2}}, new int[] {}, 0);
    }

    @Test
    void case10() {
        this.run(new int[][] {{1, 4}, {3, 5}}, new int[] {5, 4}, 2);
    }

    private void run(int[][] ranges, int[] positions, int except) {
        this.runCore(aClass -> {
            try {
                Main3 m = aClass.newInstance();
                int result = m.repair(ranges, positions);
                assertEquals(except, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

}