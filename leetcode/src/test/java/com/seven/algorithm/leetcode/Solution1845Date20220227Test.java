package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import com.seven.algorithm.leetcode.Solution1845Date20220227;

class Solution1845Date20220227Test {

    @Test
    void case01() {
        Solution1845Date20220227.SeatManager seatManager = new Solution1845Date20220227.SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
    }
    @Test
    void case02() {
        Solution1845Date20220227.SeatManager seatManager = new Solution1845Date20220227.SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
    }
    @Test
    void case03() {
        Solution1845Date20220227.SeatManager seatManager = new Solution1845Date20220227.SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
    }
    @Test
    void case04() {
        Solution1845Date20220227.SeatManager seatManager = new Solution1845Date20220227.SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(3);
        seatManager.unreserve(1);
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
    }
}