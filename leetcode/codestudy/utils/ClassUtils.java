/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.utils;


import java.util.Set;

/**
 * 类工具
 *
 * @author y30016814
 * @since 2021/12/25 16:11
 */
public class ClassUtils {
    /**
     * 获取抽象类/接口 的所有实现类（目前只能获取一层继承/实现关系）
     *
     * @param abstractClass 抽象类/接口
     * @param packagePath 抽象类/接口所在的包
     * @param <T> 抽象类/接口
     * @return 所有实现类型
     */
    public static <T> Set<Class<? extends T>> getExtendsClass(Class<T> abstractClass, String packagePath) {
        Reflections reflections = new Reflections(packagePath);
        return reflections.getSubTypesOf(abstractClass);
    }
}
