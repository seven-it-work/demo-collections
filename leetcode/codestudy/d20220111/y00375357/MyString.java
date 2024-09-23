package com.huawei.codestudy.d20220111.y00375357;

import com.huawei.codestudy.d20220111.T1;

import java.util.ArrayList;
import java.util.List;

public class MyString extends T1 {

    @Override
    public int getMaxSubStrLength(String str) {
        if (str == null) {
            return 0;
        }

        if (str.length() <= 1) {
            return str.length();
        }
        int maxSubLength = 0;
        List<String> charList = new ArrayList<>();
        String checkStr;

        for (int i = 0; i < str.length(); ) {
            checkStr = str.substring(i, i + 1);
            int index = charList.indexOf(checkStr);
            if (index != -1) {
                maxSubLength = Math.max(maxSubLength, charList.size());

                for (int j = 0; j <= index; j++) {
                    charList.remove(0);
                }
            }

            i++;
            charList.add(checkStr);
        }

        return Math.max(maxSubLength, charList.size());
    }
}
