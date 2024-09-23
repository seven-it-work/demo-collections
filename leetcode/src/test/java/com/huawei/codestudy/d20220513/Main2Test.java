/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220513;

import com.huawei.codestudy.BaseTest;
import com.huawei.codestudy.d20220513.Main2.Candidate;
import com.huawei.codestudy.d20220513.Main2.DeptDemand;
import com.huawei.codestudy.d20220513.h30022790.Question2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;

class Main2Test extends BaseTest<Main2> {

    public Main2Test() {
        super("com.huawei.codestudy.d20220513", Main2.class);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case01() {
        List<DeptDemand> deptDemandsList = new ArrayList<>(2);
        deptDemandsList.add(new DeptDemand(0, new int[] {2, 130, 120}));
        deptDemandsList.add(new DeptDemand(1, new int[] {2, 150, 150}));
        List<Candidate> candidateList = new ArrayList<>(6);
        candidateList.add(new Candidate(0, new int[] {150, 100}));
        candidateList.add(new Candidate(1, new int[] {160, 190}));
        candidateList.add(new Candidate(2, new int[] {150, 200}));
        candidateList.add(new Candidate(3, new int[] {200, 190}));
        candidateList.add(new Candidate(4, new int[] {160, 190}));
        candidateList.add(new Candidate(5, new int[] {160, 190}));
        final List<int[]> expect = Arrays.asList(
            new int[] {2, 1, 5},
            new int[] {3, 4}
        );
        run(deptDemandsList, candidateList, expect);
    }

    /**
     * 考试给的用例
     */
    @Test
    void case02() {
        List<DeptDemand> deptDemandsList = new ArrayList<>();
        deptDemandsList.add(new DeptDemand(1, new int[] {1, 180, 180}));
        deptDemandsList.add(new DeptDemand(2, new int[] {2, 100, 120}));
        deptDemandsList.add(new DeptDemand(3, new int[] {2, 100, 150}));
        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(new Candidate(0, new int[] {90, 200}));
        candidateList.add(new Candidate(1, new int[] {120, 200}));
        candidateList.add(new Candidate(2, new int[] {100, 210}));
        final List<int[]> expect = Arrays.asList(
            new int[] {},
            new int[] {2},
            new int[] {1}
        );
        run(deptDemandsList, candidateList, expect);
    }

    @Test
    void case3() {
        List<DeptDemand> deptDemandsList = new ArrayList<>();
        deptDemandsList.add(new DeptDemand(0, new int[] {1, 98, 111}));
        deptDemandsList.add(new DeptDemand(1, new int[] {0, 133, 270}));
        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(new Candidate(0, new int[] {265, 289}));
        candidateList.add(new Candidate(1, new int[] {252, 271}));
        final List<int[]> expect = Arrays.asList(
            new int[] {0},
            new int[] {}
        );
        run(deptDemandsList, candidateList, expect);
    }

    /**
     * 随机用例
     */
    @Test
    void randomCase() {
        int size = RandomUtil.randomInt(1, 3);
        final ArrayList<DeptDemand> deptDemands = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            deptDemands.add(
                new DeptDemand(i, new int[] {
                    RandomUtil.randomInt(1, 2), RandomUtil.randomInt(60, 300), RandomUtil.randomInt(60, 300)
                }));
        }
        final ArrayList<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i < RandomUtil.randomInt(1, 10000); i++) {
            candidates.add(new Candidate(i, new int[] {RandomUtil.randomInt(60, 300), RandomUtil.randomInt(60, 300)}));
        }
        HashMap<Class<? extends Main2>, List<int[]>> resultMap = new HashMap<>();
        this.runCore(aClass -> {
            try {
                Main2 t = aClass.newInstance();
                final List<int[]> results = t.getRecruitmentResults(ObjectUtil.clone(deptDemands),
                    ObjectUtil.clone(candidates));
                resultMap.put(aClass, results);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        final List<int[]> acResult = resultMap.get(Question2.class);
        resultMap.forEach((k, v) -> {
            try {
                Assertions.assertEquals(JSONUtil.toJsonStr(acResult), JSONUtil.toJsonStr(v));
            } catch (AssertionFailedError e) {
                e.printStackTrace();
                System.out.printf("测试用例：deptDemands=%s\n candidates=%s\n", deptDemands, candidates);
                classResultMap.put(k, e);
            }
        });

    }

    private void run(List<DeptDemand> deptDemands, List<Candidate> candidateAbilities, List<int[]> expect) {
        this.runCore(aClass -> {
            try {
                Main2 main = aClass.newInstance();
                List<int[]> result = main.getRecruitmentResults(ObjectUtil.clone(deptDemands),
                    ObjectUtil.clone(candidateAbilities));
                // boolean equals = IntStream.range(0, result.size())
                //     .allMatch(i -> Arrays.equals(expect[i], result.get(i)));
                // assertTrue(equals);
                Assertions.assertEquals(JSONUtil.toJsonStr(expect), JSONUtil.toJsonStr(result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}