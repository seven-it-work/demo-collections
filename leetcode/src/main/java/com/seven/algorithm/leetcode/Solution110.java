package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;
import com.seven.algorithm.utils.TreeNode;

import lombok.ToString;

public class Solution110 {
    public static void main(String[] args) {
        System.out.println(new Solution110().isBalanced(TransformUtils.arrays2TreeNode("[3,9,20,null,null,15,7]")));
        System.out.println(new Solution110().isBalanced(TransformUtils.arrays2TreeNode("[1,2,2,3,3,null,null,4,4]")));
        System.out.println(
            new Solution110().isBalanced(TransformUtils.arrays2TreeNode("[1,2,2,3,null,null,3,4,null,null,4]")));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
