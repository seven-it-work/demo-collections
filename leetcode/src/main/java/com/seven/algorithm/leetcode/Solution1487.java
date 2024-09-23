/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1487. 保证文件名唯一 https://leetcode.cn/problems/making-file-names-unique/
 *
 * @date 2023/3/3 8:42
 */
public class Solution1487 {
    public static String[] getFolderNames(String[] names) {
        return getFolderNames1_1(names);
    }

    /**
     * 时间 87 ms 击败 5.17% 内存 58.7 MB 击败 5.17%
     * 2023-3-3 10:04:07
     *
     * @param names
     * @return
     */
    private static String[] getFolderNames1_1(String[] names) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        HashMap<String, Set<Integer>> usedIndex = new HashMap<>();
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Integer integer = stringIntegerHashMap.get(names[i]);
            if (integer != null) {
                // 需要重命名
                Set<Integer> integers = usedIndex.get(name);
                if (integers != null) {
                    while (integers.contains(integer)) {
                        integer++;
                    }
                }
                String newName = name + "(" + integer + ")";
                stringIntegerHashMap.put(name, integer);
                name = newName;
            }
            // 重命名后的文件、当前文件，都需要判断是否存在索引
            if (name.contains("(") && name.contains(")")) {
                int splitIndex = name.lastIndexOf("(");
                String newName = name.substring(0, splitIndex);
                Integer index = Integer.parseInt(name.substring(splitIndex + 1).replace(")", ""));
                Set<Integer> orDefault = usedIndex.getOrDefault(newName, new HashSet<>());
                orDefault.add(index);
                usedIndex.put(newName, orDefault);
            }
            // 将当前文件索引存放
            stringIntegerHashMap.put(name, stringIntegerHashMap.getOrDefault(name, 0) + 1);
            result[i] = name;
        }
        return result;
    }

    /**
     * 思路还有点问题，不能保证对应的下标重命名准确
     * <P>比如：
     * "a1(1)","a1","a1"
     * "a1(1)","a1","a1(2)"
     * 而这套逻辑结果->"a1","a1(1)","a1(2)"
     * </P>
     *
     * @param names
     * @return
     */
    private static String[] getFolderNames1(String[] names) {
        HashMap<String, KIndex> stringKIndexHashMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            // 分割
            if (name.contains("(") && name.contains(")")) {
                int splitIndex = name.lastIndexOf("(");
                String newName = name.substring(0, splitIndex);
                String index = name.substring(splitIndex + 1).replace(")", "");
                KIndex orDefault = stringKIndexHashMap.get(newName);
                if (orDefault == null) {
                    orDefault = new KIndex(newName);
                } else if (orDefault.used.contains(index)) {
                    orDefault = stringKIndexHashMap.getOrDefault(name, KIndex.user0(name));
                    orDefault.index.add(i);
                    stringKIndexHashMap.put(name, orDefault);
                    continue;
                } else {
                    orDefault.used.add(index);
                }
                orDefault.index.add(i);
                stringKIndexHashMap.put(newName, orDefault);
            } else {
                KIndex orDefault = stringKIndexHashMap.getOrDefault(name, new KIndex(name));
                orDefault.index.add(i);
                stringKIndexHashMap.put(name, orDefault);
            }
        }
        // 组合
        String[] result = new String[names.length];
        stringKIndexHashMap.values().forEach(kIndex -> {
            int indexNow = 0;
            for (int i = 0; i < kIndex.index.size(); i++) {
                Integer index = kIndex.index.get(i);
                while (kIndex.used.contains(indexNow + "")) {
                    indexNow++;
                }
                result[index] = kIndex.name + getSuffix(indexNow);
                indexNow++;
            }
        });
        return result;
    }

    private static String getSuffix(int index) {
        if (index == 0) {
            return "";
        } else {
            return "(" + index + ")";
        }
    }

    private static class KIndex {
        private String name;
        private List<Integer> index = new ArrayList<>();
        private Set<String> used = new HashSet<>();

        public KIndex(String name) {
            this.name = name;
        }

        public static KIndex user0(String name) {
            KIndex kIndex = new KIndex(name);
            kIndex.used.add("0");
            return kIndex;
        }
    }
}
