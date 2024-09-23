/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203.h30022790;

import com.huawei.codestudy.d20211203.base.BaseT3d20211203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 第k个最大的数
 *
 * @author h30022790
 * @since 2021-12-27
 */
public class T3h30022790 extends BaseT3d20211203 {
    @Override
    public int findPassword(int[][] nums, int index) {
        if (index <= 0) {
            return -1;
        }
        // 分治
        // 假如nums有10行，那么和的序列一定是前9行的结果再与第10行进行组合，所以只用计算前9行的和的序列即可
        // 并且和的序列中第k大的数一定是由前9行的结果的前k个数与第10行的前k个数的组合，所以只用取前9行的和的序列的前k个即可
        List<Integer> subSequence = new ArrayList<>();
        for (int num : nums[0]) {
            subSequence.add(num);
        }
        for (int i = 1; i < nums.length; i++) {
            subSequence = getTopNumArr(subSequence, nums[i], index);
            Collections.reverse(subSequence);
        }
        return subSequence.get(0);
    }


    /**
     * 获取两个升序序列组合后的前k个数
     *
     * @param nums1 升序序列1
     * @param nums2 升序序列2
     * @param k 第几个数
     * @return 前k个数的组合列表
     */
    private List<Integer> getTopNumArr(List<Integer> nums1, int[] nums2, long k) {
        List<Integer> result = new ArrayList<>();
        long maxK = Math.min(k, (long) nums1.size() * nums2.length);
        // 用于保存之后访问过的位置
        Set<Long> keys = new HashSet<>();
        // 构造大顶堆
        PriorityQueue<Record> maxQueue = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        int nums1Last = nums1.size() - 1;
        int nums2Last = nums2.length - 1;
        maxQueue.offer(new Record(nums1Last, nums2Last, nums1.get(nums1Last) + nums2[nums2Last]));
        keys.add(getIndex(nums1Last, nums2Last));
        int count = 0;
        while (count < maxK) {
            // 大顶堆的头一定是最大的
            Record record = maxQueue.poll();
            if (record != null) {
                result.add(record.sum);
                count++;
                // 因为头部两个结点一开始已经被访问过了
                // 接下来应该访问的，要么是nums1[x]和nums2[y-1]，要么就是nums1[x-1]和nums2[y]
                // 原理是每次都要取最大的数，最大的数一定在这两个之中，而只要把两个数塞进大顶堆里面，就一定能从根处获取最大值
                if (record.y - 1 >= 0 && !keys.contains(getIndex(record.x, record.y - 1))) {
                    keys.add(getIndex(record.x, record.y - 1));
                    maxQueue.offer(new Record(record.x, record.y - 1, nums1.get(record.x) + nums2[record.y - 1]));
                }
                if (record.x - 1 >= 0 && !keys.contains(getIndex(record.x - 1, record.y))) {
                    keys.add(getIndex(record.x - 1, record.y));
                    maxQueue.offer(new Record(record.x - 1, record.y, nums1.get(record.x - 1) + nums2[record.y]));
                }
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 主要作用是用来保存上一次的记录
     */
    private static class Record {
        int x;  // 第一个数组中的下标

        int y;  // 第二个数组中的下标

        int sum;  // 两个数组中对应下标的值的和

        Record(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    /**
     * 计算唯一索引
     * 比如 1和2 2和1是两组不同的索引，如果用简单的加法，就都会变成3，
     * 也可以用字符串的形式，如1_2，但是这里用整数来比较效率更快
     *
     * @param aIndex 第一个数组的下标
     * @param bIndex 第二个数组的下标
     * @return 唯一索引
     */
    private long getIndex(int aIndex, int bIndex) {
        return aIndex * 10L + bIndex;
    }
}
