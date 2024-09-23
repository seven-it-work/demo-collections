/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;
import com.huawei.codestudy.utils.ArraysUtils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
class T3Test extends BaseTest<T3> {

    public T3Test() {
        super("com.huawei.codestudy.d20211217", T3.class);
    }

    @Test
    void case01() {
        int[][] cars = new int[][] {{1, 1}, {5, 1}};
        int expect = 2;
        run(cars, expect);
    }

    @Test
    void case02() {
        int[][] cars = new int[][] {{-7, 6}, {1, 10}, {-2, 1}};
        int expect = 1;
        run(cars, expect);
    }

    @Test
    void case03() {
        int[][] cars = new int[][] {{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1}};
        int expect = 5;
        run(cars, expect);
    }

    @Test
    void case04() {
        int[][] cars = new int[][] {{0, 5}, {2, 1}, {6, 1}, {9, 2}, {13, 2}, {14, 3}};
        int expect = 4;
        run(cars, expect);
    }

    @Test
    void case05() {
        int[][] cars = new int[][] {{Integer.MAX_VALUE, 2}, {Integer.MAX_VALUE - 4, 2}};
        int expect = 1;
        run(cars, expect);
    }

    @Test
    void case06() {
        int[][] cars = new int[][] {{16, 14}, {14, 6}, {5, 5}, {11, 2}, {15, 3}, {10, 14}, {6, 7}};
        int expect = 2;
        run(cars, expect);
    }

    @Test
    void case07() {
        int[][] cars = new int[][] {{8, 4}, {2, 3}, {18, 5}, {0, 18}, {17, 1}, {8, 17},};
        int expect = 4;
        run(cars, expect);
    }

    @Test
    void case08() {
        int[][] cars = new int[][] {
            {19, 2}, {14, 2}, {16, 17}, {15, 1}, {14, 10}, {10, 13}, {13, 1}, {11, 12}, {0, 7}, {4, 4}, {13, 2},
            {2, 17}, {18, 4}, {1, 1}, {0, 8}, {6, 4}, {7, 2}, {8, 3}, {17, 2},
        };
        int expect = 7;
        run(cars, expect);
    }

    @Test
    void case09() {
        int[][] cars = new int[][] {
            {15, 1}, {2, 2}, {6, 10}, {2, 18}, {2, 18}, {8, 7}, {10, 1}, {7, 11}, {0, 2}, {19, 6}, {16, 9}, {5, 5},
            {1, 13}, {15, 4}, {5, 16}, {17, 3}, {8, 1}, {9, 1}, {17, 1}, {1, 15}, {0, 9}, {6, 4}, {6, 3}, {1, 14},
            {19, 13}, {18, 1}, {5, 4}, {17, 11}, {16, 1}, {2, 5}, {18, 11}, {11, 9}, {7, 19}, {7, 1}, {2, 2}, {6, 4},
            {2, 1}, {9, 7}, {11, 5}, {12, 2}, {12, 4}, {19, 13}, {15, 2}, {16, 18}, {11, 1}, {1, 19}, {17, 1}, {12, 3},
            {0, 1}, {17, 5}, {4, 15}, {12, 19}, {15, 1}, {12, 10}, {14, 5}, {11, 1}, {8, 13}
        };
        int expect = 8;
        run(cars, expect);
    }

    @Test
    void caseRandom() {
        int len = RandomUtil.randomInt(1, 200);
        int[][] cars = new int[len][];
        for (int i = 0; i < len; i++) {
            if (RandomUtil.randomBoolean()) {
                cars[i] = new int[] {RandomUtil.randomInt(0, 20), RandomUtil.randomInt(1, 5)};
            } else {
                cars[i] = new int[] {RandomUtil.randomInt(0, 20), RandomUtil.randomInt(5, 20)};
            }
        }
        System.out.println(ArraysUtils.strArraysToString(cars));
        HashMap<Class<? extends T3>, Integer> resultMap = new HashMap<>();
        this.runCore(aClass -> {
            try {
                T3 t = aClass.newInstance();
                int result = t.getMinCollectionTime(cars.clone());
                resultMap.put(aClass, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        resultMap.forEach((k, v) -> System.out.println(k.getName() + "执行结果=" + v));
    }

    private void run(int[][] cars, int expect) {
        this.runCore(aClass -> {
            try {
                T3 t = aClass.newInstance();
                int result = t.getMinCollectionTime(cars.clone());
                log.info("解答：{}，结果={}", aClass.getName(), result);
                assertEquals(result, expect);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}