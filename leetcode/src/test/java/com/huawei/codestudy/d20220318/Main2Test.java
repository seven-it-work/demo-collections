/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220318;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main2Test extends BaseTest<Main2> {

    public Main2Test() {
        super("com.huawei.codestudy.d20220318", Main2.class);
    }

    @Test
    void case01() {
        //2台桌子
        int num = 2;
        //儿童桌1台
        int cnt = 1;
        //最长对弈时间3
        int time = 3;
        int[][] people = {{1, 0}, {1, 1}, {2, 1}, {2, 0}};
        int[] except = new int[] {1, 1, -1, -1};
        this.run(num, cnt, time, people, except);
    }

    @Test
    void case02() {
        //2台桌子
        int num = 2;
        //儿童桌1台
        int cnt = 1;
        //最长对弈时间5
        int time = 5;
        int[][] people = {{1, 0}, {1, 0}, {1, 1}, {5, 0}, {5, 1}, {6, 1}, {7, 1}, {9, 0}, {10, 0}, {11, 0}, {12, 1}};
        int[] except = new int[] {1, 1, 5, -1, 5, 7, 7, -1, -1, -1, -1};
        this.run(num, cnt, time, people, except);
    }

    @Test
    void case03() {
        //3台桌子
        int num = 3;
        //儿童桌1台
        int cnt = 1;
        //最长对弈时间4
        int time = 4;
        int[][] people = {{1, 1}, {1, 0}, {2, 0}, {2, 1}, {3, 1}, {4, 1}, {4, 1}, {6, 1}, {6, 0}, {7, 0}};
        int[] except = new int[] {2, 2, 2, 2, 4, 4, -1, -1, 7, 7};
        this.run(num, cnt, time, people, except);
    }

    private void run(int num, int cnt, int time, int[][] people, int[] except) {
        this.runCore(aClass -> {
            try {
                Main2 m = aClass.newInstance();
                int[] result = m.goGame(num, cnt, time, people);
                assertArrayEquals(except, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

}