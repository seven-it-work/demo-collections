/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220513;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main3Test extends BaseTest<Main3> {

    public Main3Test() {
        super("com.huawei.codestudy.d20220513", Main3.class);
    }

    @Test
    void case01() {
        int slider = 4;
        int[][] obstacles = {{1,1}, {3,0}};
        int expect = 14;
        run(slider, obstacles, expect);
    }

    private void run(int slider, int[][] obstacles, int expect) {
        this.runCore(aClass -> {
            try {
                Main3 main3 = aClass.newInstance();
                assertEquals(expect, main3.getMaxArea(slider, obstacles));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}