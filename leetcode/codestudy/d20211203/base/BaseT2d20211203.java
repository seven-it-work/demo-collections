/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021.12.03专业级科目1第二题
 *
 * @author y30016814
 * @since 2021/12/25 16:36
 */
public abstract class BaseT2d20211203 {
    /**
     * 复制目录
     *
     * @param targetDir 目标目录
     * @param dstDirLine dst目录线
     * @param srcDir src目录
     * @return 复制后的目录
     */
    public abstract String[] copyDir(String[] targetDir, int dstDirLine, String[] srcDir);

    /**
     * 根据输入信息完成树的构建，此部分代码可自行决定是否要改动和调用
     *
     * @param strs 输入的文件夹信息（字符串数组）
     * @return List<Node> 完成构建后的树节点列表，首元素为树的根节点
     */
    protected List<Node> buildTree(String[] strs) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int idx = strs[i].lastIndexOf(" ");
            nodes.add(new Node(strs[i].substring(idx + 1), (idx + 1) / 2));
        }
        // 完成子节点挂接
        for (int i = 0; i < nodes.size(); i++) {
            Node cur = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                Node temp = nodes.get(j);
                if (cur.level >= temp.level) {
                    break;
                }
                if (temp.level == cur.level + 1) {
                    cur.addChild(temp);
                }
            }
        }
        return nodes;
    }

    /**
     * Node 节点
     */
    protected static class Node {
        /**
         * 层级
         */
        public int level = -1;
        /**
         * 文件名
         */
        public String name = null;
        /**
         * 子文件
         */
        public List<Node> children = null;

        Node(String name, int level) {
            this.name = name;
            this.level = level;
            this.children = new ArrayList<>();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                Node temp = (Node) obj;
                return this.name.equals(temp.name) && (this.level == temp.level);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.level;
        }

        void addChild(Node child) {
            if (!this.children.contains(child)) {
                this.children.add(child);
            }
        }
    }
}
