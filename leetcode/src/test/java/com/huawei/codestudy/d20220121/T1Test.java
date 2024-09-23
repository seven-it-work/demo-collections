/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220121;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.huawei.codestudy.BaseTest;

import org.junit.jupiter.api.Test;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-22
 */
public class T1Test extends BaseTest<T1> {
    public T1Test() {
        super("com.huawei.codestudy.d20220121", T1.class);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case01() {
        int[][] lines = {{1, 1, 2, 2}, {2, 1, 0, 3}};
        int[][] positions = {{0, 1}, {1, 1}, {2, 2}};
        int rows = 3;
        int cols = 4;
        int expect = 1;
        run(rows, cols, lines, positions, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case02() {
        int[][] lines = {{3, 5, 0, 2}, {0, 3, 2, 3}, {4, 2, 6, 4}, {3, 1, 6, 4}};
        int[][] positions = {{0, 1}, {2, 4}, {1, 3}, {3, 3}, {4, 2}, {5, 5}, {5, 3}, {6, 4}};
        int rows = 7;
        int cols = 6;
        int expect = 1;
        run(rows, cols, lines, positions, expect);
    }

    @Test
    void case03() {
        int[][] lines = {{0, 1, 0, 3}};
        int[][] positions = {};
        int rows = 1;
        int cols = 5;
        int expect = 0;
        run(rows, cols, lines, positions, expect);
    }

    @Test
    void case04() {
        int[][] lines = {};
        int[][] positions = {{0, 0}};
        int rows = 1;
        int cols = 5;
        int expect = 0;
        run(rows, cols, lines, positions, expect);
    }

    @Test
    void case05() {
        int[][] lines = {{0, 0, 0, 1}, {0, 2, 0, 1}, {0, 1, 0, 1}, {0, 1, 0, 4}};
        int[][] positions = {{0, 0}, {0, 1}, {0, 2}};
        int rows = 1;
        int cols = 5;
        int expect = 3;
        run(rows, cols, lines, positions, expect);
    }

    @Test
    void case06() {
        int[][] lines = {{0, 0, 1, 0}, {0, 0, 0, 1}, {1, 0, 0, 1}, {1, 2, 0, 1}, {0, 2, 1, 1},
            {1, 2, 1, 1}, {1, 2, 0, 2}, {0, 2, 1, 3}};
        int[][] positions = {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 1}, {1, 3}};
        int rows = 2;
        int cols = 4;
        int expect = 5;
        run(rows, cols, lines, positions, expect);
    }

    @Test
    void case07() {
        int[][] lines = {{3, 5, 0, 2}, {0, 3, 2, 3}, {4, 2, 6, 4}, {3, 1, 6, 4}, {2, 4, 4, 2}};
        int[][] positions = {{0, 1}, {2, 4}, {1, 3}, {3, 3}, {4, 2}, {5, 5}, {5, 3}, {6, 4}};
        int rows = 7;
        int cols = 6;
        int expect = 2;
        run(rows, cols, lines, positions, expect);
    }

    @Test
    void case08() {
        int[][] lines = {{3, 5, 0, 2}, {0, 3, 2, 3}, {4, 2, 6, 4}, {3, 1, 6, 4}, {2, 4, 4, 2}, {5, 3, 4, 4}};
        int[][] positions = {{0, 1}, {2, 4}, {1, 3}, {3, 3}, {4, 2}, {5, 5}, {5, 3}, {6, 4}, {4, 4}};
        int rows = 7;
        int cols = 6;
        int expect = 3;
        run(rows, cols, lines, positions, expect);
    }

    @Test
    void case09() {
        int[][] lines = {
            {3, 5, 0, 2}, {0, 3, 2, 3}, {4, 2, 6, 4}, {3, 1, 6, 4}, {2, 4, 4, 2}, {5, 3, 4, 4}, {2, 4, 1, 3},
            {2, 3, 2, 4}, {2, 4, 2, 3}
        };
        int[][] positions = {{0, 1}, {2, 4}, {1, 3}, {3, 3}, {4, 2}, {5, 5}, {5, 3}, {6, 4}, {4, 4}, {2, 3}, {0, 3}};
        int rows = 7;
        int cols = 6;
        int expect = 7;
        run(rows, cols, lines, positions, expect);
    }

    @Test
    void case10() {
        int[][] lines = {
            {2, 3, 2, 5}, {2, 3, 2, 4}, {2, 2, 2, 4}
        };
        int[][] positions = {{0, 1}, {2, 4}, {1, 3}, {3, 3}, {4, 2}, {5, 5}, {5, 3}, {6, 4}, {4, 4}, {2, 3}, {0, 3}};
        int rows = 7;
        int cols = 6;
        int expect = 1;
        run(rows, cols, lines, positions, expect);
    }

    private void run(int rows, int cols, int[][] lines, int[][] positions, int expect) {
        this.runCore(aClass -> {
            try {
                T1 t1 = aClass.newInstance();
                assertEquals(expect, t1.getPaintedLineNum(rows, cols, lines, positions));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
