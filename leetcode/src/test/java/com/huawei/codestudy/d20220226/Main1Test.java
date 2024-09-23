/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220226;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main1Test extends BaseTest<Main1> {

    public Main1Test() {
        super("com.huawei.codestudy.d20220226", Main1.class);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case01() {
        String input = "61 62 63 64 32 30 31 32 4C 61 62";
        String expect = "1F3330A9";
        run(input, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case02() {
        String input = "41";
        String expect = "41FFFFFF";
        run(input, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case03() {
        String input = "68 75 61 77 65 69";
        String expect = "0D1C9E88";
        run(input, expect);
    }

    private void run(String inputStr, String expect) {
        this.runCore(aClass -> {
            try {
                Main1 main1 = aClass.newInstance();
                assertEquals(expect, main1.simpleCheckSum(inputStr));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}