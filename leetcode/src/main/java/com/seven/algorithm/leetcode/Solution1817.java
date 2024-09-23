package com.seven.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution1817 {
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        return findingUsersActiveMinutes1(logs, k);
    }

    /**
     * 时间 16 ms 击败 86.21% 内存 52.2 MB 击败 11.50%
     *
     * @param logs
     * @param k
     * @return
     */
    private static int[] findingUsersActiveMinutes1(int[][] logs, int k) {
        HashMap<Integer, Set<Integer>> idAndMinsMap = new HashMap<Integer, Set<Integer>>();
        for (int[] log : logs) {
            Set<Integer> integers = idAndMinsMap.getOrDefault(log[0], new HashSet<>());
            integers.add(log[1]);
            idAndMinsMap.put(log[0], integers);
        }
        int[] result = new int[k];
        for (Set<Integer> value : idAndMinsMap.values()) {
            result[value.size() - 1]++;
        }
        return result;
    }
}
