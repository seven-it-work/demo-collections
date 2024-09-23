package com.huawei.codestudy.d20220121.y30016814;

import com.huawei.codestudy.d20220121.T3;

/**
 * @author y30016814
 * @since 2022/1/21 19:32
 */
public class T3y30016814 extends T3 {

    /**
     * 暴力
     */
    public int numBigList(int[] cal, int size, int num) {
        return numBigListViolence(cal, size, num);
    }

    private int numBigListViolence(int[] cal, int size, int num) {
        int count = 0;
        for (int i = 0; i < cal.length - size; i++) {
            double sum = 0;
            double max = cal[i];
            for (int j = i; j < size; j++) {
                sum += cal[j];
                max = Math.max(max, cal[j]);
            }
            if (sum / size * num < max) {
                count++;
            }
        }
        return count;
    }
}
