/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217.y30016814;

import com.huawei.codestudy.d20211217.T1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第一题
 *
 * @author y30016814
 * @since 2021/12/27 14:47
 */
public class T1y30016814 extends T1 {
    private final HashMap<Integer, Integer> idSize = new HashMap<>();
    private final int capacity;
    private final int[] cun;
    private int used = 0;

    public T1y30016814(int capacity) {
        super(capacity);
        this.capacity = capacity;
        this.cun = new int[capacity];
    }

    @Override
    public int add(int fileId, int fileSize) {
        // 没有删除
        if (idSize.containsKey(fileId)) {
            return -1;
        }
        // 存储不够
        if (capacity - used < fileSize) {
            return -1;
        }
        idSize.put(fileId, fileSize);
        used += fileSize;
        return putCun(fileId, fileSize);
    }

    @Override
    public int remove(int fileId) {
        Integer remove = idSize.remove(fileId);
        if (remove == null) {
            return -1;
        }
        used -= remove;
        removeCun(fileId);
        return capacity - used;
    }

    @Override
    public int defrag() {
        List<Integer> integers = new ArrayList<>();
        idSize.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).forEach(en -> {
            for (int i = 0; i < en.getValue(); i++) {
                integers.add(en.getKey());
            }
        });
        Arrays.fill(cun, 0);
        for (int i = 0; i < integers.size(); i++) {
            cun[i] = integers.get(i);
        }
        return idSize.size();
    }

    private int putCun(int fileId, int size) {
        for (int i = 0; i < cun.length; i++) {
            if (size == 0) {
                return i - 1;
            }
            if (cun[i] == 0) {
                cun[i] = fileId;
                size--;
            }
        }
        return cun.length - 1;
    }

    private void removeCun(int fileId) {
        for (int i = 0; i < cun.length; i++) {
            if (cun[i] == fileId) {
                cun[i] = 0;
            }
        }
    }
}
