/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.huawei;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 * 标签：滑动窗口
 *
 * @author yijialuo
 * @since 2022/3/4 13:48
 */
public class Oj1790 {
    /**
     * OJ考题代码：合法mac地址
     * 不会了！！！ 太难了！！！居然有人用正则！！下次遇到匹配稍等优先考虑正则！！
     *
     * @author 命题组
     * @since 2020-04-21
     */
    public static class Main {
        /**
         * main入口由OJ平台调用
         */
        public static void main(String[] args) {
            Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
            String macAddress = cin.nextLine();
            cin.close();
            int result = getMacNum(macAddress);
            System.out.println(result);
        }

        // 待实现函数，在此函数中填入答题代码
        public static int getMacNum(String macAddress) {
            HashSet<String> strings = new HashSet<>();
            if (macAddress.length() < 17) {
                return 0;
            }
            ArrayList<Mac> macArrayList = new ArrayList<>();
            String temp = "";
            for (int i = 0; i < macAddress.length(); i++) {
                char c = macAddress.charAt(i);
                if (isLegality(c)) {
                    if (c == '-' || c == ':') {
                        if (temp.length() == 2) {
                            macArrayList.add(new Mac(c, temp));
                            temp = "";
                        } else {
                            temp = "";
                        }
                    } else {
                        temp += c;
                    }
                } else {
                    temp = "";
                }
            }
            if (temp.length() == 2) {
                macArrayList.add(new Mac('-', temp));
            }
            if (macArrayList.size() >= 6) {
                int start = 0;
                int count = 0;
                Mac pre = null;
                StringBuffer tempStr = new StringBuffer();
                for (int i = 0; i < macArrayList.size(); i++) {
                    Mac mac = macArrayList.get(i);
                    if (pre == null) {
                        pre = mac;
                        tempStr.append(mac.last).append(mac.mac);
                    } else {
                        if (count < 5) {
                            if (mac.last == pre.last) {
                                tempStr.append(mac.mac);
                                count++;
                            } else {
                                pre = null;
                                tempStr = new StringBuffer();
                                count = 0;
                                i--;
                            }
                        } else if (count == 5) {
                            tempStr.append(mac.mac);
                            if (mac.last == pre.last) {
                                count++;
                            } else {
                                pre = null;
                                tempStr = new StringBuffer();
                                count = 0;
                                i--;
                                strings.add(tempStr.substring(1).toUpperCase(Locale.ROOT));
                                tempStr = new StringBuffer();
                            }
                        } else {
                            tempStr.append(mac.mac);
                            if (mac.last == pre.last) {
                                count++;
                            } else {
                                pre = null;
                                tempStr = new StringBuffer();
                                count = 0;
                                i--;
                                String s = tempStr.substring(1).toUpperCase(Locale.ROOT);
                                tempStr = new StringBuffer();
                                System.out.println(s.length());
                                addMacStr(strings, s);
                            }
                        }
                    }
                }
                String s = tempStr.substring(1).toUpperCase(Locale.ROOT);
                System.out.println(s.length());
                addMacStr(strings, s);
            }
            return strings.size();
        }

        private static void addMacStr(Set<String> set, String macStr) {
            int end = 12;
            while (end <= macStr.length()) {
                String substring = macStr.substring(end - 12, end);
                set.add(substring);
                end += 2;
            }
        }

        private static class Mac {
            private Character last;
            private String mac;

            public Mac(Character last, String mac) {
                this.last = last;
                this.mac = mac;
            }

            @Override
            public String toString() {
                return "Mac{" +
                    "last=" + last +
                    ", mac='" + mac + '\'' +
                    '}';
            }
        }

        private static boolean isLegality(char c) {
            if ('0' <= c && c <= '9') {
                return true;
            }
            if ('a' <= c && c <= 'f') {
                return true;
            }
            if ('A' <= c && c <= 'F') {
                return true;
            }
            if (c == '-') {
                return true;
            }
            return c == ':';
        }
    }
}
