package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution1096Test {
    @Test
    void test1() {
        Assertions.assertEquals(Arrays.asList("a", "b", "c"), Solution1096.braceExpansionII("{a,b,c}"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(Arrays.asList("a", "b", "c"), Solution1096.braceExpansionII("{{a,b},{b,c}}"));
    }

    @Test
    void test3() {
        Assertions.assertEquals(Arrays.asList("ac", "ad", "bc", "bd"), Solution1096.braceExpansionII("{a,b}{c,d}"));
    }

    @Test
    void test4() {
        Assertions.assertEquals(Arrays.asList("ab", "ac", "ad"), Solution1096.braceExpansionII("a{b,c,d}"));
    }

    @Test
    void test5() {
        Assertions.assertEquals(Arrays.asList("abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"),
            Solution1096.braceExpansionII("a{b,c}{d,e}f{g,h}"));
    }

    @Test
    void test6() {
        Assertions.assertEquals(Arrays.asList("ac", "ad", "ae", "bc", "bd", "be"),
            Solution1096.braceExpansionII("{a,b}{c,{d,e}}"));
    }

    @Test
    void test7() {
        Assertions.assertEquals(Arrays.asList("a", "ab", "ac", "z"),
            Solution1096.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }
    @Test
    void test8() {
        Assertions.assertEquals(Arrays.asList("nga","ngia","ngo","ngw","ngx","noa","noia","noo","now","nox","nua","nuia","nuo","nuw","nux"),
            Solution1096.braceExpansionII("n{g,{u,o}}{a,{x,ia,o},w}"));
    }
}