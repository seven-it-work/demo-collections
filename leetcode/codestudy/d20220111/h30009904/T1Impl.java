package com.huawei.codestudy.d20220111.h30009904;

import com.huawei.codestudy.d20220111.T1;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author h30009904
 * @since 2022-01-17
 */
public class T1Impl extends T1 {
    @Override
    public int getMaxSubStrLength(String str) {
        if (str == null) {
            return 0;
        }
        Map<Character, Integer> charValueMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = 0;

        while (right < str.length()) {
            char charAt = str.charAt(right);
            Integer originIndex = charValueMap.get(charAt);
            if(originIndex != null && originIndex >= left) {
                len = Math.max(len, right - originIndex);
                left = originIndex + 1;
            } else {
                len = Math.max(len, right - left + 1);
            }
            charValueMap.put(charAt, right);
            right++;
        }
        return len;
    }
}
