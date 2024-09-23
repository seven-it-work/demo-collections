/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220408;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main1Test extends BaseTest<Main1> {
    public Main1Test() {
        super("com.huawei.codestudy.d20220408", Main1.class);
    }

    @Test
    void case01() {
        run(3, "(1+(2*3)+((8)/4))+1");
    }

    @Test
    void case02() {
        run(3, "(1+(2*3)+((8)/4))+1");
    }

    @Test
    void case03() {
        run(1, "1+(2*3)/(2-1)");
    }

    @Test
    void case04() {
        run(0, "1");
    }


    private void run(int expect, String input) {
        this.runCore(aClass -> {
            try {
                assertEquals(expect, aClass.newInstance().getMaxDepth(input));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
