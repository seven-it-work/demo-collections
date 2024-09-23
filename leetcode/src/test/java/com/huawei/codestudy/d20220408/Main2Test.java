/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220408;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main2Test extends BaseTest<Main2> {
    public Main2Test() {
        super("com.huawei.codestudy.d20220408", Main2.class);
    }

    @Test
    public void test01() {
        int[][] positions = {{1, 3}, {-2, 2}};
        int num = 1;
        run(new int[] {1}, positions, num);
    }

    @Test
    public void test02() {
        int[][] positions = {{3, 3}, {5, -1}, {-2, 4}};
        int num = 2;
        run(new int[] {0, 2}, positions, num);
    }

    @Test
    public void test03() {
        int[][] positions = {{1, 1}, {2, 1}, {1, -1}};
        int num = 2;
        run(new int[] {0, 2}, positions, num);
    }

    @Test
    public void test04() {
        int[][] positions = {{1, 0}, {0, 1}, {-1, 0}};
        int num = 2;
        run(new int[] {0, 1}, positions, num);
    }

    private void run(int[] expect, int[][] positions, int num) {
        this.runCore(aClass -> {
            try {
                assertArrayEquals(expect, aClass.newInstance().getClosestPositions(positions, num));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
