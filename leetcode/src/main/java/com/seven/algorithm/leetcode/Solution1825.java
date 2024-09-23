package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1825 {
    public static abstract class BaseMKAverage {
        protected BaseMKAverage() {
        }

        public BaseMKAverage(int m, int k) {
        }

        public abstract void addElement(int num);

        public abstract int calculateMKAverage();
    }

    /**
     * 超时了
     */
    public static class MKAverage1 extends BaseMKAverage {
        private final int m;
        private final int delNumber;
        ArrayList<Integer> nowNumbers = new ArrayList<>();

        public MKAverage1(int m, int k) {
            this.m = m;
            this.delNumber = k;
        }

        public void addElement(int num) {
            nowNumbers.add(num);
        }

        public int calculateMKAverage() {
            if (nowNumbers.size() < m) {
                return -1;
            }
            List<Integer> container =
                nowNumbers.subList(nowNumbers.size() - m, nowNumbers.size())
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            List<Integer> averages = container.subList(delNumber, container.size() - delNumber);
            double sum = averages.stream().mapToDouble(Integer::intValue).sum();
            return (int) (Math.floor(sum / averages.size()));
        }
    }
}
