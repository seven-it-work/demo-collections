/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.huawei;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

/**
 * http://oj.rnd.huawei.com/problems/1903/details
 * **题目描述**
 * <p>
 * 手机上的九宫格输入法使用 0-9 十个数字键，除了可以在“数字状态”下输入数字外，还可以在“英文状态”下通过连续多次摁某一数字键来输入对应的英文字符。每个数字键可输入的字符对应关系如图：
 * ![img](http://oj.rnd.huawei.com/public/upload/c3f4a6bd6a.png)
 * <p>
 * 说明：
 * <p>
 * - 输入法初始默认为“数字状态”，并可在“数字状态”与“英文状态”间切换。
 * - 输入法在“数字状态”下，数字键对应为单个数字，摁几次显示几个该数字。
 * - 输入法在“英文状态”下，如果数字键为 0，则对应为单字符（空格），摁几次显示几个该字符。
 * - 输入法在“英文状态”下，如果数字键为非 0，则对应为多个字符，可通过连续多次快速摁该键循环选择对应字符：
 * - 以英文状态下的数字键 2 为例，摁1次为 `a` ，2次为 `b` ，3次为 `c` ，4次又循环回 `a` 。
 * - 若连续多次摁键循环选择时被其它键或停顿中断，则输出所选择的字符。
 * <p>
 * 现给定一个仅含字符集合为 [0-9#/] 的字符串，表示用户的摁键操作，请输出实际显示出来的字符串。
 * <p>
 * > - 0-9 为数字键。
 * > - \#  表示在“数字状态”与“英文状态”之间切换。
 * > - /  停顿符，表示用户有意停顿。
 * <p>
 * **解答要求**时间限制：1000ms, 内存限制：128MB
 * <p>
 * **输入**
 * <p>
 * 一个字符串，表示用户的摁键操作，长度范围 [1,200]
 * <p>
 * **输出**
 * <p>
 * 实际显示出来的字符串
 * <p>
 * **样例**
 * <p>
 * 输入样例 1 复制
 * <p>
 * ```
 * 123
 * ```
 * <p>
 * 输出样例 1
 * <p>
 * ```
 * 123
 * ```
 * <p>
 * 提示样例 1
 * <p>
 * 输入法默认为“数字状态”，每个数字键都对应单个字符，摁键即为实际显示出来的字符串，因此输出 `123` 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入样例 2 复制
 * <p>
 * ```
 * #22/23044444411
 * ```
 * <p>
 * 输出样例 2
 * <p>
 * ```
 * bad i.
 * ```
 * <p>
 * 提示样例 2
 * <p>
 * \# 表示输入法切换为“英文状态”；
 * 数字键 2 摁2次后被停顿符 / 中断，显示 `b` ；
 * 其后，数字键 2、3、0 各摁1次后被其它键中断，显示 `a`、`d`、空格 ；
 * 然后，数字键 4 摁6次后中断，显示 `i` ；
 * 最后，数字键 1 摁2次后结束，显示 `.` 。
 * <p>
 * 因此，实际显示出来的字符串为 `bad i.`
 *
 * @author yijialuo
 * @since 2022/3/4 9:22
 */
public class Oj1903 {
    /**
     * main入口由OJ平台调用
     * AC!!
     * 总结：先写UT 如果再通过不了，看看是不是题目有什么条件遗留！ 用例多 覆盖全就一定能过！！ 最后优化圈复杂度！
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String inputStr = cin.nextLine();
        cin.close();
        String result = getDisplayString(inputStr);
        System.out.println(result);
    }

    static HashMap<Character, String> keyMap = new HashMap<>();

    static {
        keyMap.put('1', ",.");
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
    }

    // 待实现函数，在此函数中填入答题代码
    public static String getDisplayString(String inputStr) {
        StringBuffer result = new StringBuffer();
        boolean isEnglish = false;
        String temp = null;
        for (int i = 0; i < inputStr.length(); i++) {
            char charAt = inputStr.charAt(i);
            if (charAt == '#') {
                // 打断了 统计
                if (temp == null) {
                    // 跳过
                } else {
                    String tong = tong(temp);
                    result.append(tong);
                    temp = null;
                }
                isEnglish = !isEnglish;
            } else if (charAt == '/') {
                // 打断了 统计
                if (temp == null) {
                    // 跳过
                } else {
                    String tong = tong(temp);
                    result.append(tong);
                    temp = null;
                }
            } else {
                if (isEnglish) {
                    if (charAt == '0') {
                        // 打断了 统计
                        if (temp == null) {
                            // 跳过
                        } else {
                            String tong = tong(temp);
                            result.append(tong);
                            temp = null;
                        }
                        result.append(" ");
                    } else if (temp == null) {
                        temp = charAt + "";
                    } else {
                        if (temp.charAt(0) == charAt) {
                            temp += charAt;
                        } else {
                            // 打断了 统计
                            String tong = tong(temp);
                            result.append(tong);
                            temp = charAt + "";
                        }
                    }
                } else {
                    result.append(charAt);
                }
            }
        }
        // 打断了 统计
        if (temp == null) {
            // 跳过
        } else {
            String tong = tong(temp);
            result.append(tong);
        }
        return result.toString();
    }

    private static String tong(String temp) {
        String key = keyMap.get(temp.charAt(0));
        if (key == null) {
            System.out.println("key is null!!!!");
            return "";
        }
        int index = (temp.length() - 1) % key.length();
        return key.charAt(index) + "";
    }

}
