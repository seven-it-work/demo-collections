/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220318;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main1Test extends BaseTest<Main1> {

    public Main1Test() {
        super("com.huawei.codestudy.d20220318", Main1.class);
    }

    @Test
    void case01() {
        String[] options = new String[] {
            "inventorySystem", "purchase", "purchase", "produce",
            "queryMin", "produce", "purchase", "queryMin"
        };
        int[][][] input = new int[][][] {
            {{0, 2, 0}, {2, 1, 1}, {0, 1, 1}},
            {{1, 5}, {2, 4}},
            {{0, 9}, {1, 3}},
            {{0, 1}},
            {},
            {{1, 1, 2}},
            {{2, 2}},
            {}
        };
        Object[] expect = new Object[] {null, null, null, true, 2, true, null, 1};
        run(options, input, expect);
    }

    private void run(String[] options, int[][][] input, Object[] expect) {
        this.runCore(aClass -> {
            try {
                Main1 m = aClass.newInstance();
                Object[] result = new Object[options.length];
                for (int i = 0; i < options.length; i++) {
                    String option = options[i];
                    switch (option) {
                        case "inventorySystem":
                            m.inventorySystem(input[i].length, input[i]);
                            break;
                        case "purchase":
                            m.purchase(input[i]);
                            break;
                        case "produce":
                            result[i] = m.produce(input[i][0]);
                            break;
                        case "queryMin":
                            result[i] = m.queryMin();
                            break;
                        default:
                            throw new RuntimeException("不支持操作：" + option);
                    }
                }
                assertArrayEquals(expect, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}