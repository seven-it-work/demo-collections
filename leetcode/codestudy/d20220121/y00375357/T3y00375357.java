package com.huawei.codestudy.d20220121.y00375357;

import com.huawei.codestudy.d20220121.T3;

public class T3y00375357 extends T3 {
    @Override
    public int numBigList(int[] cal, int size, int num) {
        if (size <= 0 || size > cal.length) {
            return 0;
        }

        int matchCount = 0;
        double sum = 0;
        double max = 0;
        int skipCount = 1;
        for (int i = 0; i < cal.length; ) {
            CacResult cacResult = geCacResult(cal, i, size);
            sum = cacResult.getSum();
            max = cacResult.getMax();
            if (max * size > sum * num) {
                matchCount++;
            }

            if (i + size < cal.length) {
                while (true) {
                    if (max != cal[i + skipCount] && max != cal[i + skipCount + size - 1]) {
                        sum = sum + cal[i + skipCount + size - 1] - cal[i + skipCount - 1];
                        if (max * size > sum * num) {
                            matchCount++;
                            skipCount++;
                        } else {
                            i += skipCount;
                            skipCount = 1;
                            break;
                        }
                    } else {
                        i += skipCount;
                        skipCount = 1;
                        break;
                    }
                }
            } else {
                i++;
            }
        }
        return matchCount;
    }

    private CacResult geCacResult(int[] cal, int begin, int size) {
        double sum = 0;
        double max = 0;
        for (int i = 0; i < size; i++) {
            sum += cal[begin + i];
            max = Math.max(max, cal[begin + i]);
        }
        return new CacResult(max, sum);
    }
}

class CacResult {
    private double max;
    private double sum;

    public CacResult(double max, double sum) {
        this.max = max;
        this.sum = sum;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getSum() {
        return sum;
    }
}