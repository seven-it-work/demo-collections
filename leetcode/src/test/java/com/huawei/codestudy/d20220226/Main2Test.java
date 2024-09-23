/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220226;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

class Main2Test extends BaseTest<Main2> {

    public Main2Test() {
        super("com.huawei.codestudy.d20220226", Main2.class);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case01() {
        String delDirNameBunch = "A\n"
            + "|-B\n"
            + "|-|-Cpp\n"
            + "|-|-B\n"
            + "|-|-|-B\n"
            + "|-lib32";
        String dirTreeLinesStr = "B Cpp";
        int expect = 4;
        run(dirTreeLinesStr, delDirNameBunch.split("\n"), expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case02() {
        String delDirNameBunch = "A\n"
            + "|-a\n"
            + "|-|-A\n"
            + "|-A\n"
            + "|-|-A";
        String dirTreeLinesStr = "A Java";
        int expect = 3;
        run(dirTreeLinesStr, delDirNameBunch.split("\n"), expect);
    }

    @Test
    void case03() {
        String delDirNameBunch = "A\n"
            + "|-a\n"
            + "|-|-A\n"
            + "|-A\n"
            + "|-|-A\n"
            + "|-|-JAVA\n"
            + "|-|-A\n"
            + "|-|-|-b\n"
            + "|-C\n"
            + "|-|-Java";
        String dirTreeLinesStr = "A Java";
        int expect = 3;
        run(dirTreeLinesStr, delDirNameBunch.split("\n"), expect);
    }

    @Test
    void case04() {
        String delDirNameBunch = "A\n";
        String dirTreeLinesStr = "A Java";
        int expect = 0;
        run(dirTreeLinesStr, delDirNameBunch.split("\n"), expect);
    }

    @Test
    void case05() {
        String delDirNameBunch = "A\n"
            + "|-java\n"
            + "|-A\n"
            + "|-A\n"
            + "|-|-A\n"
            + "|-|-java\n";
        String dirTreeLinesStr = "|-";
        int expect = 0;
        run(dirTreeLinesStr, delDirNameBunch.split("\n"), expect);
    }

    private void run(String delDirNameBunch, String[] dirTreeLines, int expect) {
        this.runCore(aClass -> {
            try {
                Main2 main2 = aClass.newInstance();
                assertEquals(expect, main2.delDirectorys(delDirNameBunch, dirTreeLines));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}