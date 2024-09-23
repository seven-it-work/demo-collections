/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.huawei.codestudy.BaseTest;
import com.huawei.codestudy.d20211203.base.BaseT1d20211203;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
class T1Test extends BaseTest<BaseT1d20211203> {
    public T1Test() {
        super("com.huawei.codestudy.d20211203", BaseT1d20211203.class);
    }

    @Test
    void getDeletedCase01() {
        int[][] rectangles = new int[][] {
            {1, 6, 2, 2},
            {4, 6, 1, 1},
            {6, 4, 2, 1},
            {3, 2, 2, 3},
            {8, 2, 1, 1},
            {9, 5, 1, 1},
            {6, 7, 2, 1},
            {9, 1, 1, 1},
            {2, 5, 1, 1},
        };
        int[] dirtyRectangles = new int[] {1, 4, 6};
        int[] expect = new int[] {1, 2, 3, 4, 6};
        run(rectangles, dirtyRectangles, expect);
    }

    @Test
    void getDeletedCase02() {
        int[][] rectangles = new int[][] {
            {1, 6, 2, 2},
            {4, 6, 1, 1},
        };
        int[] dirtyRectangles = new int[] {};
        int[] expect = new int[] {};
        run(rectangles, dirtyRectangles, expect);
    }

    @Test
    void getDeletedCase03() {
        int[][] rectangles = new int[][] {
            {1, 6, 2, 2},
            {3, 8, 2, 2},
            {6, 4, 2, 1},
            {3, 2, 2, 3},
            {8, 2, 1, 1},
            {8, 5, 2, 2},
            {6, 7, 2, 1},
            {8, 2, 2, 2},
            {2, 5, 3, 3},
        };
        int[] dirtyRectangles = new int[] {1, 4, 6};
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        run(rectangles, dirtyRectangles, expect);
    }

    private void run(int[][] rectangles, int[] dirtyRectangles, int[] expect) {
        this.runCore(aClass -> {
            try {
                BaseT1d20211203 t1 = aClass.newInstance();
                int[] result = t1.getDeleted(rectangles.clone(), dirtyRectangles.clone());
                assertTrue(isSame(expect, result));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private boolean isSame(int[] expect, int[] result) {
        if (expect.length != result.length) {
            return false;
        }
        for (int i = 0; i < expect.length; i++) {
            if (expect[i] != result[i]) {
                return false;
            }
        }
        return true;
    }
}