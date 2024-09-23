/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220111.h30022790;

import com.huawei.codestudy.d20220111.T1;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-14
 */
public class T1MaxSubStrLength extends T1 {

    public static void main(String[] args) {
        System.out.println(new T1MaxSubStrLength().getMaxSubStrLength("acdbadbfac"));
    }

    /**
     * a c d b a d b f a c
     *
     * a c d b a
     *   c d b a d
     *       b a d b
     *         a d b f a
     *           d b f a c
     *
     * @param str 受检字符串
     * @return
     */
    @Override
    public int getMaxSubStrLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 用来存放字符第一次出现的下标
        Map<Character, Integer> indexMap = new HashMap<>();
        int left = 0;
        int max = 0;
        int tempMax = 0;
        while (left < str.length()) {
            Integer firstIndex = indexMap.putIfAbsent(str.charAt(left), left);
            if (firstIndex != null) {  // 有重复字符，加不进去，重新开始遍历，但这次要把左指针向右跳
                left = firstIndex + 1;
                max = Math.max(max, tempMax);
                tempMax = 0;
                indexMap = new HashMap<>();
            } else {
                tempMax++;
                left++;
            }
        }
        return Math.max(max, tempMax);
    }
}
