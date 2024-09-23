/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220121;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import cn.hutool.core.util.RandomUtil;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-22
 */
public class T3Test extends BaseTest<T3> {
    public T3Test() {
        super("com.huawei.codestudy.d20220121", T3.class);
    }

    @Test
    void case01() {
        int[] cal = {2, 3, 100, 3, 4, 6};
        int size = 3;
        int num = 2;
        int expect = 3;
        run(cal, size, num, expect);
    }

    @Test
    void case02() {
        int[] cal = {2, 3, 4, 3, 5, 12};
        int size = 4;
        int num = 2;
        int expect = 0;
        run(cal, size, num, expect);
    }

    @Test
    void caseRandom() {
        int len = RandomUtil.randomInt(1, 100000000);
        int[] cal = new int[len];
        for (int i = 0; i < len; i++) {
            cal[i] = RandomUtil.randomInt(1, Integer.MAX_VALUE);
        }
        int size = RandomUtil.randomInt(1, cal.length - 1);
        int num = RandomUtil.randomInt(1, 500);

        // System.out.printf("int[] cal=%s;\nint size=%s;\nint num=%s;\n", Arrays.toString(cal), size, num);

        HashMap<Class<? extends T3>, Integer> resultMap = new HashMap<>();
        this.runCore(aClass -> {
            try {
                T3 t = aClass.newInstance();
                int result = t.numBigList(cal, size, num);
                resultMap.put(aClass, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        resultMap.forEach((k, v) -> System.out.println(k.getName() + "执行结果=" + v));
    }

    private void run(int[] cal, int size, int num, int expect) {
        this.runCore(aClass -> {
            try {
                T3 t = aClass.newInstance();
                int result = t.numBigList(cal, size, num);
                Assertions.assertEquals(result, expect);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
