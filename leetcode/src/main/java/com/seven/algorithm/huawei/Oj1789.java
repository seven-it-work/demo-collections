/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.huawei;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author yijialuo
 * @since 2022/3/4 10:14
 */
public class Oj1789 {
    /**
     * OJ考题代码：简易内存池
     * AC！！！太考细节了！！
     *
     * @author 命题组
     * @since 2020-3-9
     */
    public static class Main {
        static class AllocatedMemory {
            HashMap<Integer, Integer> indexSize = new HashMap<>();
            ArrayList<int[]> releaseList = new ArrayList<>();
            int maxIndex = 0;
            int max = 100;

            AllocatedMemory() {

            }

            // 返回分配的内存首地址(string)，失败返回字符串 "error"
            String request(int size) {
                if (size==0){
                    return "error";
                }
                if (size > max - maxIndex && releaseList.isEmpty()) {
                    return "error";
                }
                if (indexSize.isEmpty()) {
                    indexSize.put(0, size);
                    maxIndex = size;
                    releaseList.clear();
                    return 0 + "";
                } else {
                    int tempIndex = this.maxIndex;
                    if (releaseList.isEmpty()) {
                        indexSize.put(maxIndex, size);
                        this.maxIndex += size;
                        return tempIndex + "";
                    } else {
                        Iterator<int[]> iterator = releaseList.iterator();
                        while (iterator.hasNext()) {
                            int[] ints = iterator.next();
                            int tempSize = ints[1] - ints[0];
                            if (size < tempSize) {
                                int index = ints[0];
                                indexSize.put(index, size);
                                ints[0] = size + ints[0];
                                return index + "";
                            } else if (size == tempSize) {
                                indexSize.put(ints[0], ints[1]);
                                iterator.remove();
                                return ints[0] + "";
                            } else {
                                // System.out.printf("需要空间%s 但是只有%s\n", size, tempSize);
                            }
                        }
                        if (size > max - maxIndex) {
                            return "error";
                        }
                        indexSize.put(maxIndex, size);
                        maxIndex += size;
                        return tempIndex + "";
                    }
                }
            }

            // 成功返回 true；失败返回 false，失败时框架会自动输出 "error"
            boolean release(int startAddress) {
                Integer remove = indexSize.remove(startAddress);
                if (remove == null) {
                    return false;
                }
                remove += startAddress;
                ArrayList<int[]> temp = new ArrayList<>();
                if (releaseList.isEmpty()) {
                    temp.add(new int[] {startAddress, remove});
                } else {
                    boolean isNotAdd = true;
                    for (int[] ints : releaseList) {
                        if (remove < ints[0]) {
                            if (isNotAdd) {
                                temp.add(new int[] {startAddress, remove});
                                isNotAdd = false;
                            }
                            temp.add(ints);
                        } else if (ints[0] == remove) {
                            // 看看能否合并
                            temp.add(new int[] {startAddress, ints[1]});
                        } else if (ints[1] == startAddress) {
                            // 看是否能合并
                            temp.add(new int[] {ints[0], remove});
                        } else {
                            temp.add(ints);
                        }
                    }
                }
                releaseList = temp;
                // 在此补充你的代码
                return true;
            }
        }

        /**
         * main入口由OJ平台调用
         */
        public static void main(String[] args) {
            AllocatedMemory allocatedMemory = new AllocatedMemory();
            Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
            int line = Integer.parseInt(cin.nextLine());
            String[][] ins = new String[line][2];
            for (int i = 0; i < line; i++) {
                ins[i] = cin.nextLine().split("=");
                if (ins[i][0].startsWith("REQUEST")) {
                    System.out.println(allocatedMemory.request(Integer.parseInt(ins[i][1])));
                } else {
                    boolean ret = allocatedMemory.release(Integer.parseInt(ins[i][1]));
                    if (!ret) {
                        System.out.println("error");
                    }
                }
            }
            cin.close();
        }
    }
}
