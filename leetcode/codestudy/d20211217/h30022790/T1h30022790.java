/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217.h30022790;

import com.huawei.codestudy.d20211217.T1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2021-12-30
 */
public class T1h30022790 extends T1 {
    private int capacity;

    private int[] address;
    /**
     * 构造函数
     *
     * @param capacity 容量
     */
    public T1h30022790(int capacity) {
        super(capacity);
        this.capacity = capacity;
        this.address = new int[capacity];
    }

    /**
     * 存储一个编号为fileId，大小为fileSize的文件
     * 如果剩余空间足够，存储成功，返回存储完成后最大的存储地址的编号
     * 如果剩余空间不够，存储失败，返回 - 1
     * 注：先从小的地址开始存储，不要求地址空间连续
     *
     * @param fileId 文件编号
     * @param fileSize 文件大小
     * @return 存储完成后最大的存储地址的编号 -1 删除失败
     */
    @Override
    public int add(int fileId, int fileSize) {
        // 统计空闲块个数
        int free = (int) IntStream.range(0, this.capacity).filter(index -> this.address[index] == 0).count();
        if (free < fileSize) {
            return -1;
        }
        int surplus = fileSize;
        int maxAddress = -99;
        for (int i = 0; i < this.capacity; i++) {
            if (surplus == 0) {
                maxAddress = i - 1;
                break;
            }
            if (this.address[i] == 0) {
                this.address[i] = fileId;
                surplus--;
            }
        }
        return maxAddress == -99 ? this.capacity - 1 : maxAddress;
    }

    /**
     * 删除磁盘中编号为 fileId 的文件
     * 文件存在，释放文件占用的存储空间，返回可用空间数
     * 文件不存在，返回 -1
     *
     * @param fileId 文件编号
     * @return 可用空间数 -1 删除失败
     */
    @Override
    public int remove(int fileId) {
        if (IntStream.range(0, this.capacity).noneMatch(index -> this.address[index] == fileId)) {
            return -1;
        }
        int free = 0;
        for (int i = 0; i < this.capacity; i++) {
            if (this.address[i] == fileId) {
                this.address[i] = 0;
            }
            if (this.address[i] == 0) {
                free++;
            }
        }
        return free;
    }

    /**
     * 文件碎片整理
     * 将文件编号一样的文件存储在连续的磁盘空间里，并案文件编号从小到大排序
     * 返回磁盘里有多少个文件
     *
     * @return 文件个数
     */
    @Override
    public int defrag() {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(this.address).forEach(fileId -> map.merge(fileId, 1, Integer::sum));
        this.address = new int[this.capacity];
        List<Integer> fileIds = map.keySet().stream()
            .filter(fileId -> fileId != 0).sorted().collect(Collectors.toList());
        int index = 0;
        for (Integer fileId : fileIds) {
            int count = map.get(fileId);
            for (int i = 0; i < count; i++) {
                this.address[i + index] = fileId;
            }
            index += count;
        }
        return fileIds.size();
    }
}
