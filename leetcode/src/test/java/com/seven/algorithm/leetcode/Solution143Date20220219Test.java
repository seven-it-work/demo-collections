package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import com.seven.algorithm.leetcode.Solution143Date20220219;

class Solution143Date20220219Test {
    Solution143Date20220219 main;

    @BeforeEach
    void init() {
        main = new Solution143Date20220219();
    }

    @Test
    void case01() {
        Solution143Date20220219.TreeNode treeNode = new Solution143Date20220219.TreeNode(5,
                new Solution143Date20220219.TreeNode(4,
                        new Solution143Date20220219.TreeNode(11,
                                new Solution143Date20220219.TreeNode(7), new Solution143Date20220219.TreeNode(2)),
                        null),
                new Solution143Date20220219.TreeNode(8,
                        new Solution143Date20220219.TreeNode(13), new Solution143Date20220219.TreeNode(4,
                        new Solution143Date20220219.TreeNode(5), new Solution143Date20220219.TreeNode(1))));
        List<List<Integer>> result = main.pathSum(treeNode, 22);
        List<List<Integer>> expect = Arrays.asList(Arrays.asList(5, 4, 11, 2), Arrays.asList(5, 8, 4, 5));
        assertEquals(result, expect);
    }

    @Test
    void case02() {
        Solution143Date20220219.TreeNode treeNode = new Solution143Date20220219.TreeNode(1,
                new Solution143Date20220219.TreeNode(2),
                new Solution143Date20220219.TreeNode(3));
        List<List<Integer>> result = main.pathSum(treeNode, 5);
        List<List<Integer>> expect = Collections.emptyList();
        assertEquals(result, expect);
    }

    @Test
    void case03() {
        Solution143Date20220219.TreeNode treeNode = new Solution143Date20220219.TreeNode(1,
                new Solution143Date20220219.TreeNode(2),
                new Solution143Date20220219.TreeNode(3));
        List<List<Integer>> result = main.pathSum(treeNode, 4);
        List<List<Integer>> expect = Collections.singletonList(Arrays.asList(1, 3));
        assertEquals(result, expect);
    }

    @Test
    void case04() {
        Solution143Date20220219.TreeNode treeNode = new Solution143Date20220219.TreeNode(1,
                new Solution143Date20220219.TreeNode(2), null);
        List<List<Integer>> result = main.pathSum(treeNode, 0);
        List<List<Integer>> expect = Collections.emptyList();
        assertEquals(result, expect);
    }

    @Test
    void case05() {
        Solution143Date20220219.TreeNode treeNode = new Solution143Date20220219.TreeNode(1,
                new Solution143Date20220219.TreeNode(2), null);
        List<List<Integer>> result = main.pathSum(treeNode, 1);
        List<List<Integer>> expect = Collections.emptyList();
        assertEquals(result, expect);
    }

    @Test
    void case06() {
        Solution143Date20220219.TreeNode treeNode = null;
        List<List<Integer>> result = main.pathSum(treeNode, 1);
        List<List<Integer>> expect = Collections.emptyList();
        assertEquals(result, expect);
    }
}