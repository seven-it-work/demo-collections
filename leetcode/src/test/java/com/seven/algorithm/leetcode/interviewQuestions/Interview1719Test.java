package com.seven.algorithm.leetcode.interviewQuestions;

import com.seven.algorithm.TestBase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;

class Interview1719Test {

    @Test
    void test1() {
        int[] result = {2, 3};
        Assertions.assertArrayEquals(result, Interview1719.missingTwo(new int[] {1}));
    }

    @Test
    void test2() {
        int[] result = {1, 4};
        Assertions.assertArrayEquals(result, Interview1719.missingTwo(new int[] {2, 3}));
    }

    @Test
    void test3() {
        int[] result = {1, 2};
        Assertions.assertArrayEquals(result, Interview1719.missingTwo(new int[] {3}));
    }

    @Test
    void test4() {
        final String string = FileUtil.readString(
            new File(TestBase.TEST_RESOURCES + "leetcode/interviewQuestions/Interview1719.json").getAbsolutePath(),
            StandardCharsets.UTF_8);
        int[] ints = JSONUtil.parseArray(string).stream().mapToInt(obj -> ((int) obj)).toArray();
        int[] result = {2050, 8184};
        Assertions.assertArrayEquals(result, Interview1719.missingTwo(ints));
    }
}