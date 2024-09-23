/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220111.y30016814;

import com.huawei.codestudy.d20220111.T1;

import java.util.HashMap;

/**
 * @author y30016814
 * @since 2022/1/13 15:57
 */
public class T1y30016814 extends T1 {
    @Override
    public int getMaxSubStrLength(String str) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            char tempChar = str.charAt(i);
            Integer integer = charIndexMap.get(tempChar);
            if (integer == null) {
                charIndexMap.put(tempChar, i);
            } else {
                maxLength = Math.max(maxLength, i - integer);
                i = integer;
                charIndexMap.clear();
            }
        }
        maxLength = Math.max(maxLength, charIndexMap.size());
        return maxLength;
    }
}
