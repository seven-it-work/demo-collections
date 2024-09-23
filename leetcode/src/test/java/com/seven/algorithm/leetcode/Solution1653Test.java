package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1653Test {
    @Test
    void test1() {
        Assertions.assertEquals(2, Solution1653.minimumDeletions("aababbab"));
    }
    @Test
    void test2() {
        Assertions.assertEquals(2, Solution1653.minimumDeletions("bbaaaaabb"));
    }

    /**
     * ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa
     * a a aaaa     aaa a      aaa  aa a  a    aa    aa  a  a aa   a a aa
     *  b b    bbbbb   b bbbbbb   bb  b bb bbbb  bbbb  bb bb b  bbb b b
     */
    @Test
    void test3() {
        Assertions.assertEquals(25, Solution1653.minimumDeletions("ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa"));
    }
}