/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220111;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author y30016814
 * @since 2022/1/22 10:21
 */
@Slf4j
public class T3Test extends BaseTest<T3> {
    public T3Test() {
        super("com.huawei.codestudy.d20220111", T3.class);
    }

    @Test
    void case01() {
        int[] nums = new int[] {1, 3, 1};
        int k = 1;
        int expect = 0;
        run(nums, k, expect);
    }

    @Test
    void case02() {
        int[] nums = new int[] {1, 3, 4, 5};
        int k = 1;
        int expect = 1;
        run(nums, k, expect);
    }

    private void run(int[] nums, int k, int expect) {
        this.runCore(aClass -> {
            try {
                T3 t = aClass.newInstance();
                int result = t.smallestDistancePair(nums, k);
                log.info("解答：{}，结果={}", aClass.getName(), result);
                assertEquals(result, expect);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
