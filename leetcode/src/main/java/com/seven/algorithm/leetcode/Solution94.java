package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;
import com.seven.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 前序遍历：{@link Solution145}
 * 中序遍历：{@link Solution94}
 * 后序遍历：{@link Solution145}
 * 层序遍历：{@link Solution102}
 */
public class Solution94 {
    public static void main(String[] args) {
        String nodes = "[1,null,2]";
        // System.out.println(new Solution94().inorderTraversal_qian(TransformUtils.arrays2TreeNode(nodes)));
        System.out.println(new Solution94().inorderTraversal(TransformUtils.arrays2TreeNode(nodes)));
    }

    private static void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 前序遍历
        traverse(root.left, list);
        // 中序遍历
        list.add(root.val);
        traverse(root.right, list);
        // 后序遍历
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        traverse(root, integers);
        return integers;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
