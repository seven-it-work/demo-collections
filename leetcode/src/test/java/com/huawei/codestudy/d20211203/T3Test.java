/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.huawei.codestudy.BaseTest;
import com.huawei.codestudy.d20211203.base.BaseT3d20211203;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
class T3Test extends BaseTest<BaseT3d20211203> {
    public T3Test() {
        super("com.huawei.codestudy.d20211203", BaseT3d20211203.class);
    }

    @Test
    void findPasswordCase01() {
        int[][] ints = new int[][] {
            {1, 4, 7, 10},
            {2, 3, 5, 9},
            {1, 1, 12, 13},
        };
        int index = 5;
        int expect = 28;
        run(ints, index, expect);
    }

    @Test
    void findPasswordCase02() {
        int[][] ints = new int[][] {
            {1}
        };
        int index = 1;
        int expect = 1;
        run(ints, index, expect);
    }

    @Test
    void findPasswordCase04() {
        int[][] ints = new int[][] {
            {1039, 1924, 2069, 5736, 7360, 8238},
            {415, 1756, 3999, 6325, 7056, 8871}
        };
        int index = 8;
        int expect = 12792;
        run(ints, index, expect);
    }

    @Test
    void findPasswordCaseRandom() {
        int row = RandomUtil.randomInt(1, 200);
        int col = RandomUtil.randomInt(1, 200);
        int[][] ints = new int[row][col];
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                integers.add(RandomUtil.randomInt(10000));
            }
            List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
            ints[i] = collect.stream().mapToInt(Integer::valueOf).toArray();
        }
        int index = RandomUtil.randomInt(1, row * col);

        HashMap<Class<? extends BaseT3d20211203>, Integer> resultMap = new HashMap<>();
        this.runCore(aClass -> {
            try {
                BaseT3d20211203 t = aClass.newInstance();
                int result = t.findPassword(ints, index);
                resultMap.put(aClass, result);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        resultMap.forEach((k, v) -> System.out.println(k.getName() + "执行结果=" + v));
    }

    private void run(int[][] ints, int index, int expect) {
        this.runCore(aClass -> {
            try {
                BaseT3d20211203 t = aClass.newInstance();
                int result = t.findPassword(ints.clone(), index);
                assertTrue(isSame(expect, result));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private boolean isSame(int expect, int result) {
        return expect == result;
    }
}