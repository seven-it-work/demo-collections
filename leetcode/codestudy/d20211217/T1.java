/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211217;

/**
 * 2021.12.17专业级科目1第一题
 *
 * @author y30016814
 * @since 2021/12/27 14:11
 */
public abstract class T1 {
    /**
     * 构造函数
     *
     * @param capacity 容量
     */
    public T1(int capacity) {
    }

    /**
     * 添加文件
     *
     * @param fileId 文件ID
     * @param fileSize 文件大小
     * @return 如果剩余空间足够，存储成功，返回存储完成后最大的存储地址的编号 如果剩余空间不够，存储失败，返回 - 1
     */
    public abstract int add(int fileId, int fileSize);

    /**
     * 删除磁盘中编号为 fileId 的文件
     *
     * @param fileId 文件ID
     * @return 文件存在，释放文件占用的存储空间，返回 1,文件不存在，返回 -1
     */
    public abstract int remove(int fileId);

    /**
     * 将文件编号一样的文件存储在连续的磁盘空间里，并案文件编号从小到大排序
     *
     * @return 返回磁盘里有多少个文件
     */
    public abstract int defrag();
}
