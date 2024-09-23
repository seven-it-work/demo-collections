/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220111;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class T1Test extends BaseTest<T1> {

    public T1Test() {
        super("com.huawei.codestudy.d20220111", T1.class);
    }

    @Test
    void case01() {
        String str = "abc";
        int expect = 3;
        run(str, expect);
    }

    @Test
    void case02() {
        String str = "abcdecdeabcde";
        int expect = 5;
        run(str, expect);
    }

    @Test
    void case03() {
        String str = "abcabcbb";
        int expect = 3;
        run(str, expect);
    }

    @Test
    void case04() {
        String str = "";
        int expect = 0;
        run(str, expect);
    }

    @Test
    void case05() {
        String str = "bbbbb";
        int expect = 1;
        run(str, expect);
    }

    @Test
    void case06() {
        String str = "pwwkew";
        int expect = 3;
        run(str, expect);
    }

    @Test
    void caseRandom() {
        int strLen = RandomUtil.randomInt(1, 1000);
        String str = RandomUtil.randomString(strLen);
        HashMap<Class<? extends T1>, Integer> resultMap = new HashMap<>();
        this.runCore(aClass -> {
            try {
                T1 t = aClass.newInstance();
                int result = t.getMaxSubStrLength(str);
                resultMap.put(aClass, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        resultMap.forEach((k, v) -> System.out.println(k.getName() + "执行结果=" + v));
    }

    private void run(String str, int expect) {
        this.runCore(aClass -> {
            try {
                T1 t = aClass.newInstance();
                int result = t.getMaxSubStrLength(str);
                log.info("解答：{}，结果={}", aClass.getName(), result);
                assertEquals(result, expect);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}