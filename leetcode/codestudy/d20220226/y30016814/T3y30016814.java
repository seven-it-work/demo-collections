/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220226.y30016814;

import com.huawei.codestudy.d20220226.Main3;

import java.util.Comparator;
import java.util.HashSet;

/**
 * AC
 *
 * @author yijialuo
 * @since 2022/2/25 14:26
 */
public class T3y30016814 extends Main3 {
    @Override
    public int calcRunTime(int[][] mutexs, int[] appRunTimes) {
        // 1. 找不互斥的组合
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < appRunTimes.length; i++) {
            set.add(i + 1);
        }
        HashSet<HashSet<Integer>> tempCollect = new HashSet<>();
        tempCollect.add(set);
        for (int[] mutex : mutexs) {
            HashSet<HashSet<Integer>> temp = new HashSet<>();
            for (HashSet<Integer> integers : tempCollect) {
                if (integers.contains(mutex[0]) && integers.contains(mutex[1])) {
                    integers.remove(mutex[0]);
                    HashSet<Integer> re01 = new HashSet<>(integers);
                    temp.add(re01);
                    integers.add(mutex[0]);
                    integers.remove(mutex[1]);
                    HashSet<Integer> re02 = new HashSet<>(integers);
                    temp.add(re02);
                } else {
                    temp.add(integers);
                }
            }
            tempCollect = temp;
        }
        int size = tempCollect.stream().max(Comparator.comparingInt(HashSet::size)).get().size();
        return tempCollect.stream()
            .filter(integers -> integers.size() >= size)
            .map(integers -> integers.stream().mapToInt(integer -> appRunTimes[integer - 1]).sum())
            .min(Integer::compare)
            .get();
    }
}
