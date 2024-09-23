/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.utils;

import com.huawei.codestudy.d20211203.base.BaseT1d20211203;
import com.huawei.codestudy.d20211203.y30016814.T1y30016814;

import org.junit.jupiter.api.Test;

import java.util.Set;

class ClassUtilsTest {

    @Test
    void getExtendsClass() {
        Set<Class<? extends BaseT1d20211203>> extendsClass = ClassUtils.getExtendsClass(BaseT1d20211203.class,
            "com.huawei.codestudy.d20211203");
        assert extendsClass.contains(T1y30016814.class);
    }
}