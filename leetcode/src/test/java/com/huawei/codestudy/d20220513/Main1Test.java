/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220513;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;
import com.huawei.codestudy.d20220513.h30022790.Question1;
import com.huawei.codestudy.utils.ArraysUtils;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.HashMap;

import cn.hutool.core.util.RandomUtil;

class Main1Test extends BaseTest<Main1> {

    public Main1Test() {
        super("com.huawei.codestudy.d20220513", Main1.class);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case01() {
        int[] productions = {803, 804, 805, 802, 803, 804, 805, 804};
        int[] plans = {1, 0, 1, 0, 1, 0, 1, 0};
        int window = 3;
        int expect = 4824;
        run(productions, plans, window, expect);
    }

    /**
     * 随机用例
     */
    @Test
    void case02() {
        int size = RandomUtil.randomInt(1, 100000);
        int[] productions = new int[size];
        int[] plans = new int[size];
        for (int i = 0; i < productions.length; i++) {
            productions[i] = RandomUtil.randomInt(1, 1000);
        }
        for (int i = 0; i < plans.length; i++) {
            plans[i] = RandomUtil.randomBoolean() ? 0 : 1;
        }
        int window = RandomUtil.randomInt(0, size);

        HashMap<Class<? extends Main1>, Integer> resultMap = new HashMap<>();
        this.runCore(aClass -> {
            try {
                Main1 t = aClass.newInstance();
                final int maxQuantity = t.getMaxQuantity(productions.clone(), plans.clone(), window);
                resultMap.put(aClass, maxQuantity);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        final Integer acResult = resultMap.get(Question1.class);
        resultMap.forEach((k, v) -> {
            try {
                assertEquals(acResult, v);
            } catch (AssertionFailedError e) {
                e.printStackTrace();
                System.out.printf("测试用例：productions=%s，plans=%s，window=%s\n",
                    ArraysUtils.strArraysToString(productions), ArraysUtils.strArraysToString(plans), window);
                classResultMap.put(k, e);
            }
        });
    }

    private void run(int[] productions, int[] plans, int window, int expect) {
        this.runCore(aClass -> {
            try {
                Main1 main1 = aClass.newInstance();
                assertEquals(expect, main1.getMaxQuantity(productions.clone(), plans.clone(), window));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}