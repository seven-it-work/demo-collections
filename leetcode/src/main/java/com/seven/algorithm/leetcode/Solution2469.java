/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

/**
 * 2469. 温度转换 https://leetcode.cn/problems/convert-the-temperature/description/
 *
 * @date 2023/3/21 10:16
 */
public class Solution2469 {
    public static double[] convertTemperature(double celsius) {
        return convertTemperature1(celsius);
    }

    /**
     * 时间 8 ms 击败 1.39% 内存 42.2 MB 击败 5.23%
     * 2023-3-21 10:19:58
     *
     */
    private static double[] convertTemperature1(double celsius) {
        java.math.BigDecimal celsiusBigDecimal = new java.math.BigDecimal(celsius);
        double kelvin = celsiusBigDecimal.add(new java.math.BigDecimal("273.15")).doubleValue();
        double fahrenheit = celsiusBigDecimal.multiply(new java.math.BigDecimal("1.8"))
            .add(new java.math.BigDecimal(32))
            .doubleValue();
        return new double[] {kelvin, fahrenheit};
    }
}
