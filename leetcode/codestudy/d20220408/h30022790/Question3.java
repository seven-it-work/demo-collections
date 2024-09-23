/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220408.h30022790;

import com.huawei.codestudy.d20220408.Main3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Question3 extends Main3 {
    private List<int[]> rankList;
    private Map<Integer, List<Integer>> userRecordMap;

    @Override
    public void initSkiRankingSystem() {
        this.rankList = new ArrayList<>();
        this.userRecordMap = new HashMap<>();
    }

    @Override
    public void addRecord(int userId, int duration) {
        List<Integer> userRecordList = userRecordMap.get(userId);
        if (userRecordList == null) {
            userRecordList = new ArrayList<>();
        }
        userRecordList.add(duration);
        userRecordList.sort(Comparator.comparingInt(o -> o));
        userRecordMap.put(userId, userRecordList);

        int index = IntStream.range(0, rankList.size())
            .filter(i -> rankList.get(i)[1] > duration)
            .findFirst()
            .orElse(-1);
        if (index == -1) {
            rankList.add(new int[] {userId, duration});
        } else {
            rankList.add(index, new int[] {userId, duration});
        }
    }

    @Override
    public int[] getTopAthletes(int num) {
        Set<Integer> set = new HashSet<>();
        return rankList.stream()
            .filter(ints -> set.add(ints[0]))
            .limit(num)
            .mapToInt(ints -> ints[0])
            .toArray();
    }

    @Override
    public int[] queryTop3Record(int userId) {
        List<Integer> userRecordList = userRecordMap.get(userId);
        return userRecordList == null || userRecordList.size() == 0
            ? new int[] {}
            : userRecordList.stream().limit(3).mapToInt(v -> v).toArray();
    }
}
