/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203.y30016814;

import com.huawei.codestudy.d20211203.base.BaseT2d20211203;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 第二题
 *
 * @author y30016814
 * @since 2021/12/25 16:38
 */
public class T2y30016814 extends BaseT2d20211203 {
    @Override
    public String[] copyDir(String[] targetDir, int dstDirLine, String[] srcDir) {
        // 1. 利用api构成成树
        List<Node> targetTree = buildTree(targetDir);
        Node targetNode = targetTree.get(dstDirLine - 1);
        // 2. 更具level制作空格
        String space = " ";
        for (int i = 0; i < targetNode.level; i++) {
            space += "  ";
        }
        // 遍历srcDir 全部加入space
        for (int i = 0; i < srcDir.length; i++) {
            srcDir[i] = space + srcDir[i];
        }
        // 将srcDir 转换为tree
        List<Node> srcTree = buildTree(srcDir);
        // 获取srcTree的root
        Node srcRoot = srcTree.get(0);
        // 将srcRoot.child 加入到 targetNode.child中
        mergeNode(targetNode, srcRoot);
        // 将Node 转换为str
        Node root = targetTree.get(0);
        return buildStr(root).toArray(new String[] {});
    }

    private List<String> buildStr(Node node) {
        ArrayList<String> result = new ArrayList<>();
        String temp = node.name;
        for (int i = 0; i < node.level; i++) {
            temp = "  " + temp;
        }
        result.add(temp);
        if (node.children != null && !node.children.isEmpty()) {
            node.children.forEach(child -> result.addAll(buildStr(child)));
        }
        return result;
    }

    private void mergeNode(Node node1, Node node2) {
        List<Node> children = node1.children;
        HashMap<String, Node> map = new HashMap<>();
        children.forEach(node -> map.put(node.level + node.name, node));
        ArrayList<Node> childrenList = new ArrayList<>();
        for (Node child : node2.children) {
            Node node = map.get(child.level + child.name);
            if (node != null) {
                mergeNode(node, child);
            } else {
                childrenList.add(child);
            }
        }
        node1.children.addAll(childrenList);
        node1.children.sort(Comparator.comparing(node -> node.name));
    }
}
