/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.huawei.codestudy.BaseTest;
import com.huawei.codestudy.d20211203.base.BaseT2d20211203;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
class T2Test extends BaseTest<BaseT2d20211203> {

    public T2Test() {
        super("com.huawei.codestudy.d20211203", BaseT2d20211203.class);
    }

    @Test
    void copyDirCase01() {
        String targetDirStr = ""
            + "home\n"
            + "  GAMES\n"
            + "  usr\n"
            + "    DRIVERS\n"
            + "    local\n"
            + "      lib64\n"
            + "    log\n"
            + "  var\n"
            + "    log";
        String srcDirStr = ""
            + "bin\n"
            + "  LICENSES\n"
            + "    conf\n"
            + "  local\n"
            + "    lib32\n"
            + "  log";
        String expectStr = ""
            + "home\n"
            + "  GAMES\n"
            + "  usr\n"
            + "    DRIVERS\n"
            + "    LICENSES\n"
            + "      conf\n"
            + "    local\n"
            + "      lib32\n"
            + "      lib64\n"
            + "    log\n"
            + "  var\n"
            + "    log";
        int dstDirLine = 3;
        String[] targetDir = targetDirStr.split("\n");
        String[] srcDir = srcDirStr.split("\n");
        String[] expect = expectStr.split("\n");
        run(dstDirLine, targetDir, srcDir, expect);
    }

    private void run(int dstDirLine, String[] targetDir, String[] srcDir, String[] expect) {
        this.runCore(aClass -> {
            try {
                BaseT2d20211203 t = aClass.newInstance();
                String[] strings = t.copyDir(targetDir.clone(), dstDirLine, srcDir.clone());
                assertTrue(this.isSame(expect, strings));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private boolean isSame(String[] expect, String[] result) {
        if (expect.length != result.length) {
            return false;
        }
        for (int i = 0; i < expect.length; i++) {
            if (!expect[i].equals(result[i])) {
                return false;
            }
        }
        return true;
    }
}