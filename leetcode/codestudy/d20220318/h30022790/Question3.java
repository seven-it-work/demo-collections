/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220318.h30022790;

import com.huawei.codestudy.d20220318.Main3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Question3 extends Main3 {
    @Override
    public int repair(int[][] ranges, int[] positions) {
        int ans = 0;
        Arrays.sort(positions);
        Arrays.sort(ranges, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j = 0;
        for (int p : positions) {
            // 将ranges中所有小于等于该点的左端点所对应的区间右端点放入小根堆中
            while (j < ranges.length && ranges[j][0] <= p) {
                pq.add(ranges[j++][1]);
            }
            // 每次取出堆头判断是否能够包含当前维修点
            while (!pq.isEmpty()) {
                int cur = pq.poll();
                if (cur >= p) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
