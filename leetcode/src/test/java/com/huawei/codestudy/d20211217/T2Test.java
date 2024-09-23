/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
class T2Test extends BaseTest<T2> {

    public T2Test() {
        super("com.huawei.codestudy.d20211217", T2.class);
    }

    @Test
    void case01() {
        int num = 5;
        int[][] operations = new int[][] {{0, 2}, {0, 1}, {1, 2}, {0, 2}, {0, 1}};
        int[] expect = new int[] {1, 1, 0, 0, 1};
        run(num, operations, expect);
    }

    @Test
    void case02() {
        int num = 6;
        int[][] operations = new int[][] {{1, 1}, {0, 4}, {0, 1}, {1, 4}, {1, 1}, {0, 4}};
        int[] expect = new int[] {1, 1, 0, 0, 0, 1};
        run(num, operations, expect);
    }

    @Test
    void caseRandom() {
        int num = RandomUtil.randomInt(0, 1000);
        int[][] operations = new int[num][];
        for (int i = 0; i < num; i++) {
            operations[i] = new int[] {RandomUtil.randomInt(0, 2), RandomUtil.randomInt(1, num)};
        }
        HashMap<Class<? extends T2>, int[]> resultMap = new HashMap<>();
        this.runCore(aClass -> {
            try {
                T2 t2 = aClass.newInstance();
                int[] ints = t2.checkConnectivity(num, operations.clone());
                resultMap.put(aClass, ints);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        resultMap.forEach((k, v) -> System.out.println(k.getName() + "执行结果=" + Arrays.toString(v)));
    }

    private void run(int num, int[][] operations, int[] expect) {
        this.runCore(aClass -> {
            try {
                T2 t2 = aClass.newInstance();
                int[] ints = t2.checkConnectivity(num, operations.clone());
                assertTrue(isSame(ints, expect));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private boolean isSame(int[] expect, int[] result) {
        if (expect.length != result.length) {
            return false;
        }
        for (int i = 0; i < expect.length; i++) {
            if (expect[i] != result[i]) {
                return false;
            }
        }
        return true;
    }

}