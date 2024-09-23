package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;
import com.seven.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 前序遍历：{@link Solution145}
 * 中序遍历：{@link Solution94}
 * 后序遍历：{@link Solution145}
 * 层序遍历：{@link Solution102}
 */
public class Solution102 {
    public static void main(String[] args) {
        System.out.println(new Solution102().levelOrder(TransformUtils.arrays2TreeNode("[3,9,20,null,null,15,7]")));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> data = new HashMap<>();
        this.doIt(root, 1, data);
        return new ArrayList<>(data.values());
    }

    private void doIt(TreeNode root, int level, HashMap<Integer, List<Integer>> data) {
        if (root==null){
            return;
        }
        List<Integer> orDefault = data.getOrDefault(level, new ArrayList<>());
        orDefault.add(root.val);
        data.put(level, orDefault);
        if (root.left != null) {
            doIt(root.left, level + 1, data);
        }
        if (root.right != null) {
            doIt(root.right, level + 1, data);
        }
    }
}
