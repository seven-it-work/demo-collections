package com.huawei.codestudy.d20211217.h30009904;

import com.huawei.codestudy.d20211217.T2;

import java.util.Arrays;

/**
 * 功能描述
 *
 * @author h30009904
 * @since 2021-12-31
 */
public class DeviceConnect extends T2 {
    boolean[][] findPath = null;
    @Override
    public int[] checkConnectivity(int num, int[][] operations) {
        boolean[][] arr = new boolean[num][2];
        for (boolean[] booleans : arr) {
            Arrays.fill(booleans, true);
        }
        int[] result = new int[num];
        Arrays.fill(result, 1);
        for (int i = 0, operationsLength = operations.length; i < operationsLength; i++) {
            int[] operation = operations[i];
            // [ [0, 2], [0, 1], [1, 2], [0, 2], [0, 1] ]
            arr[operation[1]][operation[0]] = !arr[operation[1]][operation[0]];
            if (!init(arr)) {
                result[i] = 0;
            }
        }
        return result;
    }

    private boolean init(boolean[][] arr) {
        findPath = new boolean[arr.length][2];
        return find(arr, 0, 0) ||
            find(arr, 0, 1);
    }

    private boolean find(boolean[][] arr, int i, int index) {
        if (i == arr.length) {
            return true;
        }
        if (index > 1 || index < 0 || i > arr.length - 1 ||findPath[i][index]) {
            return false;
        }
        findPath[i][index] = true;
        boolean[] booleans = arr[i];
        if (!booleans[index]) {
            return false;
        }
        return find(arr, i + 1, index) || find(arr, i, index + 1) ||
        find(arr, i, index - 1);
    }
}
