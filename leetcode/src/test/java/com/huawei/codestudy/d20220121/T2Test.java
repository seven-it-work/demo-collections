/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220121;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-22
 */
public class T2Test extends BaseTest<T2> {
    public T2Test() {
        super("com.huawei.codestudy.d20220121", T2.class);
    }

    @Test
    void case01() {
        String[] ops = {"StorageSystem", "store", "retrieve", "query"};
        int[][] datas = {{2, 2, 1, 1, 2}, {0, 1, 0, 2}, {3, 1}, {3}};
        Object[] expects = {null, 4, 2, new int[] {1, 0, 0}};
        run(ops, datas, expects);
    }

    @Test
    void case02() {
        String[] ops = {
            "StorageSystem", "query", "store", "store", "store", "query", "store", "retrieve", "store", "query",
            "query", "retrieve"
        };
        int[][] datas = {
            {2, 2, 1, 3, 2}, {0}, {0, 21, 1, 3}, {1, 22, 1, 4}, {1, 23, 0, 2}, {1}, {4, 26, 1, 2}, {5, 21},
            {6, 24, 0, 7}, {7}, {8}, {9, 22}
        };
        Object[] expects = {
            null, new int[] {0, 0, 0}, 9, 8, 4, new int[] {0, 3, 0}, -1, 6, 14, new int[] {1, 2, 1},
            new int[] {1, 1, 2}, -1
        };
        run(ops, datas, expects);
    }

    private void run(String[] ops, int[][] datas, Object[] expects) {
        this.runCore(aClass -> {
            try {
                T2 t2 = aClass.newInstance();
                t2.storageSystem(datas[0][0], datas[0][1], datas[0][2], datas[0][3],
                    datas[0][4]);
                Object[] result = new Object[ops.length];
                result[0] = null;
                for (int i = 1; i < ops.length; i++) {
                    switch (ops[i]) {
                        case "store":
                            result[i] = t2.store(datas[i][0], datas[i][1], datas[i][2], datas[i][3]);
                            break;
                        case "retrieve":
                            result[i] = t2.retrieve(datas[i][0], datas[i][1]);
                            break;
                        case "query":
                            result[i] = t2.query(datas[i][0]);
                            break;
                        default:
                            break;
                    }
                }
                assertArrayEquals(expects, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
