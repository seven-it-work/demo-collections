/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220121;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-22
 */
public abstract class T2 {
    public abstract void storageSystem(int coldStorageNum, int coldStoragePrice, int normalStorageNum,
        int normalStoragePrice, int delay);

    public abstract int store(int date, int storageId, int storageType, int storageDays);

    public abstract int retrieve(int date, int storageId);

    public abstract int[] query(int date);
}
