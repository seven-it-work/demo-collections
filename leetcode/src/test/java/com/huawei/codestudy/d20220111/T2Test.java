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
 * @since 2022/1/22 11:46
 */
@Slf4j
public class T2Test extends BaseTest<T2> {
    public T2Test() {
        super("com.huawei.codestudy.d20220111", T2.class);
    }

    @Test
    void case01() {
        int[] nums = new int[] {2, 3, 2};
        int expect = 3;
        run(nums, expect);
    }

    @Test
    void case02() {
        int[] nums = new int[] {1, 2, 3, 1};
        int expect = 4;
        run(nums, expect);
    }

    private void run(int[] nums, int expect) {
        this.runCore(aClass -> {
            try {
                T2 t = aClass.newInstance();
                int result = t.rob(nums);
                log.info("解答：{}，结果={}", aClass.getName(), result);
                assertEquals(result, expect);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
