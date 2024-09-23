package com.huawei.codestudy.d20211217.y00375357;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiskSystem extends com.huawei.codestudy.d20211217.T1 {
    private final int capacity;
    private int freeCapacity;
    private int[] memoryUsed;
    private final Map<Integer, Integer> currentFile = new HashMap<>();

    public DiskSystem(int capacity) {
        super(capacity);
        this.capacity = capacity;
        this.freeCapacity = capacity;
        this.memoryUsed = new int[capacity];
    }

    @Override
    public int add(int fileId, int fileSize) {
        // 空间不足直接返回 -1
        if (freeCapacity < fileSize) {
            return -1;
        }

        int needSaveCount = fileSize;
        int maxPosition = 0;
        // 从头开始找到能存放的位置
        for (int i = 0; i < capacity; i++) {
            // 已经保存完
            if (needSaveCount <= 0) {

                break;
            }

            if (memoryUsed[i] == 0) {
                memoryUsed[i] = fileId;
                maxPosition = i;
                needSaveCount--;
            }
        }

        // 刷新可用空间
        freeCapacity -= fileSize;

        // 加入文件缓存中
        currentFile.put(fileId, fileSize);

        return maxPosition;
    }

    @Override
    public int remove(int fileId) {
        // 没有，直接返回
        if (!currentFile.containsKey(fileId)) {
            return -1;
        }

        // 刷新可用空间
        freeCapacity += currentFile.get(fileId);

        // 移除文件
        currentFile.remove(fileId);
        // 清除使用标记
        for (int i = 0; i < capacity; i++) {
            if (memoryUsed[i] == fileId) {
                memoryUsed[i] = 0;
            }
        }

        return freeCapacity;
    }

    @Override
    public int defrag() {
        int[] newMemoryUsed = new int[capacity];
         Set<Integer> fields = currentFile.keySet();
        // 排序当前所有的文件id
        fields.stream().sorted();
        int currentPosition = 0;
        for (Integer field : fields) {
            // 获取文件数
            for (int i = 0; i < currentFile.get(field); i++) {
                newMemoryUsed[currentPosition + i] = field;
            }
            currentPosition += currentFile.get(field);
        }

        this.memoryUsed = newMemoryUsed;

        return currentFile.size();
    }
}
