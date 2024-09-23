/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy;

import com.huawei.codestudy.utils.ClassUtils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.opentest4j.AssertionFailedError;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import lombok.extern.log4j.Log4j2;

/**
 * @author y30016814
 * @since 2021/12/31 14:31
 */
@Log4j2
public class BaseTest<T> {
    protected Map<Class<? extends T>, Throwable> classResultMap = new HashMap<>();
    protected String packagePath;
    protected Class<T> tClass;

    public BaseTest(String packagePath, Class<T> tClass) {
        this.packagePath = packagePath;
        this.tClass = tClass;
    }

    @BeforeEach
    void init() {

        ClassUtils.getExtendsClass(tClass, packagePath)
            .forEach(aClass -> classResultMap.put(aClass, null));
    }

    @AfterEach
    void checkIsSuccess() {
        classResultMap.forEach((k, v) -> {
            if (v != null) {
                throw new RuntimeException("有解答错误，请看日志：\n" + k + " 解答错误：\n" + v);
            }
        });

    }

    protected void runCore(Consumer<Class<? extends T>> consumer) {
        for (Class<? extends T> aClass : classResultMap.keySet()) {
            try {
                consumer.accept(aClass);
            } catch (AssertionFailedError | Exception throwable) {
                log.error("{} 解答错误！", aClass.getName());
                throwable.printStackTrace();
                classResultMap.put(aClass, throwable);
            }
        }
    }
}


