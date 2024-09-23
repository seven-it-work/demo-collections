package com.huawei.codestudy.d20211217.h30009904;

import com.huawei.codestudy.d20211217.T1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述
 *
 * @author h30009904
 * @since 2021-12-31
 */
public class DiskSystem extends T1 {
    private Map<Integer, Integer> map = new HashMap<>();

    List<Integer> list = new ArrayList<>();

    int[] arr;

    private int capacity;

    private int usedSize;
    /**
     * 构造函数
     *
     * @param capacity 容量
     */
    public DiskSystem(int capacity) {
        super(capacity);
        arr = new int[capacity];
        this.capacity = capacity;
        this.usedSize = 0;
    }

    @Override
    public int add(int fileId, int fileSize) {
        if (fileSize + usedSize > capacity) {
            return -1;
        }
        map.put(fileId, fileSize);
        list.add(fileId);
        usedSize += fileSize;
        int tempSize = fileSize;
        int i = 0;
        while (tempSize > 0) {
            if (arr[i] == 0) {
                arr[i] = fileId;
                tempSize--;
            }
            i++;
        }
        return i - 1;
    }

    @Override
    public int remove(int fileId) {
        if (!map.containsKey(fileId)) {
            return -1;
        }
        int fileSize = map.remove(fileId);
        for (int j = 0, arrLength = arr.length; j < arrLength; j++) {
            if (arr[j] == fileId) {
                arr[j] = 0;
            }
        }
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == fileId) {
                index = i;
            }
        }
        if (index != -1) {
            list.remove(index);
        }
        usedSize -= fileSize;
        return capacity - usedSize;
    }

    @Override
    public int defrag() {
        // 整理
        list.sort(Comparator.comparingInt(a -> a));
        arr = new int[capacity];
        int temp = 0;
        for (Integer fileId : list) {
            int fileSize = map.get(fileId);
            for (int i = 0; i < fileSize; i++) {
                arr[temp] = fileId;
                temp++;
            }
        }
        return list.size();
    }
}
