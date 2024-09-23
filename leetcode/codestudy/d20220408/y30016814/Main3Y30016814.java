/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220408.y30016814;

import com.huawei.codestudy.d20220408.Main3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 耗时：35min
 *
 * @author yijialuo
 * @since 2022/4/25 9:20
 */
public class Main3Y30016814 extends Main3 {
    private int putIndex;
    private HashMap<Integer, User> userIdMap;

    public static void main(String[] args) {
        Main3Y30016814 main3Y30016814 = new Main3Y30016814();
        main3Y30016814.initSkiRankingSystem();
        main3Y30016814.addRecord(20, 8);
        main3Y30016814.addRecord(22, 6);
        main3Y30016814.addRecord(20, 6);
        System.out.println(Arrays.toString(main3Y30016814.getTopAthletes(4)));
        main3Y30016814.addRecord(33, 5);
        main3Y30016814.addRecord(22, 9);
        main3Y30016814.addRecord(31, 4);
        System.out.println(Arrays.toString(main3Y30016814.getTopAthletes(4)));
        main3Y30016814.addRecord(20, 8);
        System.out.println(Arrays.toString(main3Y30016814.queryTop3Record(20)));
        main3Y30016814.addRecord(20, 6);
        System.out.println(Arrays.toString(main3Y30016814.queryTop3Record(20)));
    }

    @Override
    public void initSkiRankingSystem() {
        userIdMap = new HashMap<Integer, User>();
        putIndex = 0;
    }

    @Override
    public void addRecord(int userId, int duration) {
        User user = userIdMap.getOrDefault(userId, new User(userId, putIndex++));
        user.addDuration(duration);
        userIdMap.put(userId, user);
    }

    @Override
    public int[] getTopAthletes(int num) {
        List<User> collect = userIdMap.values()
            .stream()
            .sorted((o1, o2) -> {
                if (o1.getBestResults() == o2.getBestResults()) {
                    return o2.putIndex - o1.putIndex;
                }
                return o1.getBestResults() - o2.getBestResults();
            })
            .collect(Collectors.toList());
        return collect.subList(0, Math.min(num, collect.size()))
            .stream()
            .map(User::getId)
            .mapToInt(Integer::intValue)
            .toArray();
    }

    @Override
    public int[] queryTop3Record(int userId) {
        User user = userIdMap.get(userId);
        if (user != null) {
            return user.getTop3Record();
        }
        return new int[0];
    }

    private static class User {
        private List<Integer> durations = new ArrayList<>();
        private int id;
        private boolean isSort = false;
        private int putIndex;

        public User(int id, int putIndex) {
            this.id = id;
            this.putIndex = putIndex;
        }

        public void addDuration(int duration) {
            this.durations.add(duration);
            this.isSort = false;
        }

        public int[] getTop3Record() {
            this.checkAndSort();
            int[] result = new int[Math.min(3, durations.size())];
            for (int i = 0; i < result.length; i++) {
                result[i] = durations.get(i);
            }
            return result;
        }

        public int getBestResults() {
            this.checkAndSort();
            if (!durations.isEmpty()) {
                return durations.get(0);
            } else {
                return Integer.MAX_VALUE;
            }
        }

        public int getId() {
            return id;
        }

        public int getPutIndex() {
            return putIndex;
        }

        @Override
        public String toString() {
            return "User{" +
                "durations=" + durations +
                ", id=" + id +
                ", isSort=" + isSort +
                ", putIndex=" + putIndex +
                '}';
        }

        private void checkAndSort() {
            if (!this.isSort) {
                durations.sort(Integer::compareTo);
                this.isSort = true;
            }
        }
    }
}
