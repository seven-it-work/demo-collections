package com.seven.algorithm.leetcode.swordFingerOffer;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SwordFingerOffer47Test {
    private static int[][] formatArray(String s) {
        List<List<Integer>> lists = JSONUtil.toBean(s, new TypeReference<>() {
        }, true);
        System.out.println(lists);
        int[][] ints = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            ints[i] = lists.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return ints;
    }

    @Test
    void test1() {
        String s = "[\n"
            + "  [1,3,1],\n"
            + "  [1,5,1],\n"
            + "  [4,2,1]\n"
            + "]";
        int[][] ints = formatArray(s);
        Assertions.assertEquals(12, SwordFingerOffer47.maxValue(ints));
    }


}