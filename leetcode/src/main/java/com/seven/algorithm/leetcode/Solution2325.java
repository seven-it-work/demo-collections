package com.seven.algorithm.leetcode;

import java.util.HashMap;

public class Solution2325 {

    public static String decodeMessage(String key, String message) {
        return decodeMessage1(key, message);
    }

    /**
     * 2023-2-1 09:30:00
     * 时间 4 ms 击败 72.99% 内存 41.3 MB 击败 55.47%
     * 2023-2-1 10:00:54
     * @param key
     * @param message
     * @return
     */
    private static String decodeMessage1(String key, String message) {
        char[] keyChars = key.toCharArray();
        HashMap<Character, String> keyAndPasswordMap = new HashMap<>();

        int index=97;
        for (char keyChar : keyChars) {
            if (keyChar == ' ') {

            } else if (!keyAndPasswordMap.containsKey(keyChar)) {
                String value = Character.toString(index++);
                keyAndPasswordMap.put(keyChar, value);
            }
        }
        char[] messageChars = message.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char messageChar : messageChars) {
            if (messageChar == ' ') {
                result.append(messageChar);
            } else {
                result.append(keyAndPasswordMap.get(messageChar));
            }
        }
        return result.toString();
    }
}
