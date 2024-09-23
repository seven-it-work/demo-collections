/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220304;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main1Test extends BaseTest<Main1> {

    public Main1Test() {
        super("com.huawei.codestudy.d20220304", Main1.class);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case01() {
        String username = "John";
        String password = "John@huawei.com";
        String expect = "empty";
        run(username, password, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case02() {
        String username = "John";
        String password = "abcABC@dd";
        String expect = "ABC@dd";
        run(username, password, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case03() {
        String username = "China";
        String password = "#zhonguo123456CHINA@";
        String expect = "123456CHINA@";
        run(username, password, expect);
    }

    private void run(String username, String password, String expect) {
        this.runCore(aClass -> {
            try {
                Main1 main1 = aClass.newInstance();
                assertEquals(expect, main1.getBestPassword(username, password));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}