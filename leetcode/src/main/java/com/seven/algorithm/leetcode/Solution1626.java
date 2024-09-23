/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 1626. 无矛盾的最佳球队 https://leetcode.cn/problems/best-team-with-no-conflicts/
 *
 * @date 2023/3/22 10:59
 */
public class Solution1626 {
    public static int bestTeamScore(int[] scores, int[] ages) {
        return bestTeamScore1(scores, ages);
    }

    /**
     * 额 思路复杂，不好梳理，待换思路
     *
     * @param scores
     * @param ages
     * @return
     */
    private static int bestTeamScore1(int[] scores, int[] ages) {
        ArrayList<People> peopleArrayList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            People people = new People(scores[i], ages[i], i);
            peopleArrayList.add(people);
        }
        for (int i = 0; i < peopleArrayList.size(); i++) {
            for (int j = i + 1; j < peopleArrayList.size(); j++) {
                People peopleI = peopleArrayList.get(i);
                People peopleJ = peopleArrayList.get(j);
                if (peopleI.compareIsContradictory(peopleJ)) {
                    peopleI.contradictionPeople.add(peopleJ);
                    peopleJ.contradictionPeople.add(peopleI);
                } else {
                    peopleI.notContradictionPeople.add(peopleJ);
                    peopleJ.notContradictionPeople.add(peopleI);
                }
            }
        }
        int max = 0;
        for (People people : peopleArrayList) {
            HashSet<Integer> integers = new HashSet<>();
            int tempMax = people.scores;
            integers.add(people.index);
            for (People notContradictionPerson : people.notContradictionPeople) {
                if (!integers.contains(notContradictionPerson.index)) {
                    tempMax += notContradictionPerson.scores;
                } else {

                }
            }
        }
        System.out.println(peopleArrayList);
        return 1;
    }

    private static class People {
        private final int scores;
        private final int age;
        private final int index;
        private final Set<People> contradictionPeople = new HashSet<>();
        private final Set<People> notContradictionPeople = new HashSet<>();

        public People(int scores, int age, int index) {
            this.scores = scores;
            this.age = age;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            People people = (People) o;
            return index == people.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }

        public boolean compareIsContradictory(People people) {
            if (this.age > people.age && this.scores < people.scores) {
                return true;
            }
            if (this.age < people.age && this.scores > people.scores) {
                return true;
            }
            return false;
        }
    }

}
