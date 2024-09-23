/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220408;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main3Test extends BaseTest<Main3> {
    public Main3Test() {
        super("com.huawei.codestudy.d20220408", Main3.class);
    }

    @Test
    public void test01() {
        String[] ops = {"SkiRankingSystem", "addRecord", "addRecord", "getTopAthletes", "queryTop3Record"};
        int[][] datas = {{}, {1, 10}, {2, 8}, {3}, {1}};
        Object[] result = {null, null, null, new int[] {2, 1}, new int[] {10}};
        run(result, ops, datas);
    }

    @Test
    public void test02() {
        String[] ops = {
            "SkiRankingSystem", "addRecord", "addRecord", "addRecord", "getTopAthletes", "addRecord", "addRecord",
            "addRecord", "getTopAthletes", "addRecord", "queryTop3Record", "addRecord", "queryTop3Record"
        };
        int[][] datas = {
            {}, {20, 8}, {22, 6}, {20, 6}, {4}, {33, 5}, {22, 9}, {31, 4}, {4}, {20, 8}, {20}, {20, 6}, {20}
        };
        Object[] result = {
            null, null, null, null, new int[] {22, 20}, null, null, null, new int[] {31, 33, 22, 20}, null,
            new int[] {6, 8, 8}, null, new int[] {6, 6, 8}
        };
        run(result, ops, datas);
    }

    private void run(Object[] expect, String[] ops, int[][] datas) {
        this.runCore(aClass -> {
            try {
                Main3 m = aClass.newInstance();
                Object[] result = new Object[ops.length];
                for (int i = 0; i < ops.length; i++) {
                    switch (ops[i]) {
                        case "SkiRankingSystem":
                            result[i] = null;
                            m.initSkiRankingSystem();
                            break;
                        case "addRecord":
                            result[i] = null;
                            m.addRecord(datas[i][0], datas[i][1]);
                            break;
                        case "getTopAthletes":
                            result[i] = m.getTopAthletes(datas[i][0]);
                            break;
                        case "queryTop3Record":
                            result[i] = m.queryTop3Record(datas[i][0]);
                            break;
                    }
                }
                assertArrayEquals(expect, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
