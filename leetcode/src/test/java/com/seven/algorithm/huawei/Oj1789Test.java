package com.seven.algorithm.huawei;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Oj1789Test {
    @Test
    @DisplayName("case01")
    void case01() {
        Oj1789.Main.AllocatedMemory allocatedMemory = new Oj1789.Main.AllocatedMemory();
        assertEquals("0", allocatedMemory.request(10));
        assertEquals("10", allocatedMemory.request(20));
    }

    @Test
    @DisplayName("case02")
    void case02() {
        Oj1789.Main.AllocatedMemory allocatedMemory = new Oj1789.Main.AllocatedMemory();
        assertEquals("0", allocatedMemory.request(10));
        assertEquals("10", allocatedMemory.request(20));
        assertEquals(true, allocatedMemory.release(0));
        assertEquals("30", allocatedMemory.request(20));
        assertEquals("0", allocatedMemory.request(10));
    }

    @Test
    @DisplayName("一直申请 超过100")
    void case03() {
        Oj1789.Main.AllocatedMemory allocatedMemory = new Oj1789.Main.AllocatedMemory();
        assertEquals("0", allocatedMemory.request(10));
        assertEquals("10", allocatedMemory.request(20));
        assertEquals("30", allocatedMemory.request(30));
        assertEquals("60", allocatedMemory.request(40));
        assertEquals("error", allocatedMemory.request(50));
    }

    @Test
    @DisplayName("一直申请 然后 释放 申请和释放相同")
    void case04() {
        Oj1789.Main.AllocatedMemory allocatedMemory = new Oj1789.Main.AllocatedMemory();
        assertEquals("0", allocatedMemory.request(10));
        assertEquals(true, allocatedMemory.release(0));
        assertEquals("0", allocatedMemory.request(20));
        assertEquals(true, allocatedMemory.release(0));
        assertEquals(false, allocatedMemory.release(0));
        assertEquals("0", allocatedMemory.request(10));
        assertEquals(false, allocatedMemory.release(10));
        assertEquals(true, allocatedMemory.release(0));
    }

    @Test
    @DisplayName("一直申请 然后 释放 申请和释放相同, 地址不同")
    void case05() {
        Oj1789.Main.AllocatedMemory allocatedMemory = new Oj1789.Main.AllocatedMemory();
        assertEquals("0", allocatedMemory.request(10));
        assertEquals("10", allocatedMemory.request(20));
        assertEquals(true, allocatedMemory.release(0));
        assertEquals("30", allocatedMemory.request(30));
        assertEquals(true, allocatedMemory.release(10));
        assertEquals("0", allocatedMemory.request(11));
        assertEquals("11", allocatedMemory.request(10));
    }

    @Test
    @DisplayName("不连续 存 放")
    void case06() {
        Oj1789.Main.AllocatedMemory allocatedMemory = new Oj1789.Main.AllocatedMemory();
        assertEquals("0", allocatedMemory.request(3));
        assertEquals("3", allocatedMemory.request(3));
        assertEquals("6", allocatedMemory.request(4));
        assertEquals(true, allocatedMemory.release(3));
        assertEquals("10", allocatedMemory.request(4));
        assertEquals("3", allocatedMemory.request(2));
        assertEquals(true, allocatedMemory.release(6));
        assertEquals("5", allocatedMemory.request(5));
        assertEquals("14", allocatedMemory.request(6));
    }

    @Test
    @DisplayName("加满再释放")
    void error01() {
        Oj1789.Main.AllocatedMemory allocatedMemory = new Oj1789.Main.AllocatedMemory();
        assertEquals("0", allocatedMemory.request(10));
        assertEquals("10", allocatedMemory.request(20));
        assertEquals("30", allocatedMemory.request(30));
        assertEquals("60", allocatedMemory.request(40));
        assertEquals(true, allocatedMemory.release(30));
        assertEquals("30", allocatedMemory.request(10));
        assertEquals("40", allocatedMemory.request(10));
        assertEquals("50", allocatedMemory.request(10));
        assertEquals("error", allocatedMemory.request(10));
    }

    @Test
    @DisplayName("直接加满+再加0")
    void error02() {
        Oj1789.Main.AllocatedMemory allocatedMemory = new Oj1789.Main.AllocatedMemory();
        assertEquals("0", allocatedMemory.request(100));
        assertEquals("error", allocatedMemory.request(0));
    }

    @Test
    @DisplayName("直接加满+再加0")
    void error03() {
        Oj1789.Main.AllocatedMemory allocatedMemory = new Oj1789.Main.AllocatedMemory();
        assertEquals("0", allocatedMemory.request(50));
        assertEquals("50", allocatedMemory.request(50));
        assertEquals(true, allocatedMemory.release(50));
        assertEquals("error", allocatedMemory.request(60));
        assertEquals("error", allocatedMemory.request(0));
    }

}