/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.utils;

import cn.hutool.json.JSONUtil;

/**
 * 一些数组优化工具
 *
 * @author y30016814
 * @since 2022/1/7 16:45
 */
public class ArraysUtils {

    /**
     * 打印出更好看的字符串数组，便于复制
     *
     * @param arr 数组
     * @return 数组字符
     */
    public static String strArraysToString(Object[] arr) {
        return JSONUtil.toJsonStr(arr).replace("[", "{").replace("]", "}");
    }

    public static String strArraysToString(int[] arr) {
        return JSONUtil.toJsonStr(arr).replace("[", "{").replace("]", "}");
    }
}
