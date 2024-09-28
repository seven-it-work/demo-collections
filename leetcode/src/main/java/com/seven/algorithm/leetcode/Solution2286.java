package com.seven.algorithm.leetcode;

import java.util.*;

public class Solution2286 {
    public static void main(String[] args) {
        BookMyShow bms = new BookMyShow(2, 5); // There are 2 rows with 5 seats each
        System.out.println(Arrays.toString(bms.gather(4, 0))); // return [0, 0]
        // The group books seats [0, 3] of row 0.
        System.out.println(Arrays.toString(bms.gather(2, 0))); // return []
        // There is only 1 seat left in row 0,
        // so it is not possible to book 2 consecutive seats.
        System.out.println(bms.scatter(5, 1)); // return True
        // The group books seat 4 of row 0 and seats [0, 3] of row 1.
        System.out.println(bms.scatter(5, 1)); // return False
        // There is only one seat left in the hall.
    }


    public static class BookMyShow {
        private int n; // 排数
        private int m; // 每排的座位数
        private int[] minTree; // 线段树，用于存储每段区间的最小值
        private long[] sumTree; // 线段树，用于存储每段区间的总和

        // 构造函数，初始化线段树
        public BookMyShow(int n, int m) {
            this.n = n;
            this.m = m;
            this.minTree = new int[4 * n]; // 初始化最小值线段树
            this.sumTree = new long[4 * n]; // 初始化总和线段树
            buildTree(1, 0, n - 1); // 构建线段树
        }

        // 构建线段树
        private void buildTree(int node, int start, int end) {
            if (start == end) { // 如果是叶子节点
                minTree[node] = m; // 设置最小值为该排的座位数
                sumTree[node] = m; // 设置总和为该排的座位数
            } else {
                int mid = (start + end) / 2; // 计算中间点
                buildTree(node * 2, start, mid); // 递归构建左子树
                buildTree(node * 2 + 1, mid + 1, end); // 递归构建右子树
                minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]); // 更新当前节点的最小值
                sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1]; // 更新当前节点的总和
            }
        }

        // 修改线段树中的值
        private void modify(int node, int start, int end, int index, int value) {
            if (start == end) { // 如果是叶子节点
                minTree[node] = value; // 更新最小值
                sumTree[node] = value; // 更新总和
            } else {
                int mid = (start + end) / 2; // 计算中间点
                if (index <= mid) { // 如果索引在左边
                    modify(node * 2, start, mid, index, value); // 递归修改左子树
                } else { // 如果索引在右边
                    modify(node * 2 + 1, mid + 1, end, index, value); // 递归修改右子树
                }
                minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]); // 更新当前节点的最小值
                sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1]; // 更新当前节点的总和
            }
        }

        // 为k名观众分配连续的座位
        public int[] gather(int k, int maxRow) {
            int row = -1; // 初始化行号
            int col = -1; // 初始化列号
            for (int i = 0; i <= maxRow; i++) { // 遍历所有行
                if (minTree[i + 1] >= k) { // 如果当前行的最小值大于等于k
                    row = findRow(i, 1, 0, n - 1, k); // 查找具体的行号
                    if (row != -1) { // 如果找到了行号
                        col = findCol(row, k); // 查找具体的列号
                        break; // 结束循环
                    }
                }
            }
            if (row != -1 && col != -1) { // 如果找到了合适的座位
                for (int i = 0; i < k; i++) { // 更新线段树
                    modify(1, 0, n - 1, row, m - i - 1); // 更新该行的最小值和总和
                }
                return new int[]{row, col}; // 返回座位信息
            }
            return new int[0]; // 否则返回空数组
        }

        // 查找具体的行号
        private int findRow(int index, int node, int start, int end, int k) {
            if (start == end) { // 如果是叶子节点
                return start; // 返回行号
            } else {
                int mid = (start + end) / 2; // 计算中间点
                if (minTree[node * 2] >= k) { // 如果左子树满足条件
                    return findRow(index, node * 2, start, mid, k); // 递归查找左子树
                } else { // 如果右子树满足条件
                    return findRow(index, node * 2 + 1, mid + 1, end, k); // 递归查找右子树
                }
            }
        }

        // 查找具体的列号
        private int findCol(int row, int k) {
            int col = 0; // 初始化列号
            while (col + k <= m && minTree[row * 2 + 1] >= k) { // 寻找连续的k个座位
                col += m; // 移动到下一组
            }
            return col; // 返回列号
        }

        // 为k名观众分配非连续的座位
        public boolean scatter(int k, int maxRow) {
            int i = 0; // 初始化行号
            while (i <= maxRow && k > 0) { // 遍历所有行
                int used = (int) Math.min(k, sumTree[i + 1]); // 计算当前行可以使用的座位数
                k -= used; // 减去已经使用的座位数
                modify(1, 0, n - 1, i, m - used); // 更新线段树
                i++; // 移动到下一排
            }
            return k <= 0; // 如果k<=0，表示成功分配了所有座位
        }
    }

    /**
     * 暴力模式，由通义解答（自己也能想到的）
     * 超出内存限制
     */
    public static class BookMyShow2 {
        private final int nRows;
        private final int seatsPerRow;
        private final boolean[][] occupiedSeats;

        public BookMyShow2(int n, int m) {
            this.nRows = n;
            this.seatsPerRow = m;
            this.occupiedSeats = new boolean[n][m];
        }

        /**
         * 尝试为k名观众分配连续的座位。
         *
         * @param k      观众人数
         * @param maxRow 最大行号
         * @return 长度为2的数组，包含座位的行号和座位号；如果无法分配，则返回空数组。
         */
        public int[] gather(int k, int maxRow) {
            for (int r = 0; r <= maxRow; r++) {
                for (int c = 0; c <= seatsPerRow - k; c++) {
                    boolean canAllocate = true;
                    for (int i = 0; i < k; i++) {
                        if (occupiedSeats[r][c + i]) {
                            canAllocate = false;
                            break;
                        }
                    }
                    if (canAllocate) {
                        // 分配座位
                        for (int i = 0; i < k; i++) {
                            occupiedSeats[r][c + i] = true;
                        }
                        return new int[]{r, c};
                    }
                }
            }
            return new int[0];
        }

        /**
         * 尝试为k名观众分配座位，不一定连续。
         *
         * @param k      观众人数
         * @param maxRow 最大行号
         * @return 如果可以分配座位则返回true，否则返回false。
         */
        public boolean scatter(int k, int maxRow) {
            int[] availableSeats = new int[k];
            int count = 0;
            for (int r = 0; r <= maxRow && count < k; r++) {
                for (int c = 0; c < seatsPerRow && count < k; c++) {
                    if (!occupiedSeats[r][c]) {
                        availableSeats[count++] = r * seatsPerRow + c; // 存储座位信息以便排序
                    }
                }
            }

            if (count < k) {
                // 无法分配足够的座位
                return false;
            }

            Arrays.sort(availableSeats, 0, k);

            for (int i = 0; i < k; i++) {
                int index = availableSeats[i];
                int row = index / seatsPerRow;
                int col = index % seatsPerRow;
                occupiedSeats[row][col] = true;
            }

            return true;
        }
    }

    /**
     * 第一次尝试，失败
     * 2024-9-28 20:00:28
     * 2024-9-28 20:43:26
     */
    public static class BookMyShow1 {
        // 这个map存放已经分配的位置 key为行数，value为数组[0,1]表示0~1索引都占了，[3]表示第三个被占了
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        int row = 0;
        int setSize = 0;

        public BookMyShow1(int n, int m) {
            this.row = n;
            this.setSize = m;
        }

        public int[] gather(int k, int maxRow) {
            for (int i = 0; i <= maxRow; i++) {
                Integer integer = integerHashMap.get(i);
                if (integer == null) {
                    integerHashMap.put(i, k);
                    return new int[]{i, 0};
                } else {
                    if (this.setSize - integer >= k) {
                        // 可以加入
                        integerHashMap.put(i, integer + k);
                        return new int[]{i, integer - 1};
                    } else {
//                    不可以加入
                    }
                }
            }
            return new int[]{};
        }

        public boolean scatter(int k, int maxRow) {
            int remainder = k;
            for (int i = 0; i <= maxRow; i++) {
                if (remainder <= 0) {
                    return true;
                }
                Integer integer = integerHashMap.get(i);
                if (integer == null) {
                    integerHashMap.put(i, remainder);
                    if (remainder > this.setSize) {
                        remainder -= this.setSize;
                    } else {
                        return true;
                    }
                } else {
                    if (this.setSize > integer) {
                        // 可以加入
                        if (remainder > this.setSize - integer) {
                            remainder -= (this.setSize - integer);
                            integerHashMap.put(i, this.setSize);
                        } else {
                            integerHashMap.put(i, integer + remainder);
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
