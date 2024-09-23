package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;
import com.seven.algorithm.utils.TreeNode;

import java.util.Arrays;

/**
 *
 */
public class Solution106 {
    public static void main(String[] args) {
        System.out.println(new Solution106().buildTree(TransformUtils.intArrays("[9,3,15,20,7]"),
            TransformUtils.intArrays("[9,15,7,20,3]")));
        System.out.println(
            new Solution106().buildTree(TransformUtils.intArrays("[2,1]"), TransformUtils.intArrays("[2,1]")));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }
        int postorderRootIndex = postorder.length - 1;
        int inorderRootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorderRootIndex]) {
                inorderRootIndex = i;
                break;
            }
        }
        if (inorderRootIndex == -1) {
            throw new RuntimeException("错误数据");
        }
        int postorderLeftIndex = -1;
        if (inorderRootIndex == 0) {
            postorderLeftIndex = 1;
        } else {
            // 在后序中找到最左节点开头
            for (int i = 0; i < postorder.length; i++) {
                if (postorder[i] == inorder[inorderRootIndex - 1]) {
                    postorderLeftIndex = i;
                    break;
                }
            }
        }
        TreeNode treeNode = new TreeNode(postorder[postorderRootIndex]);
        // 分割
        int[] postorderLeftArray = Arrays.copyOfRange(postorder, 0, postorderLeftIndex+1);
        int[] postorderRightArray = Arrays.copyOfRange(postorder, postorderLeftIndex+1, postorderRootIndex);
        int[] inorderLeftArray = Arrays.copyOfRange(inorder, 0, inorderRootIndex);
        int[] inorderRightArray = Arrays.copyOfRange(inorder, inorderRootIndex + 1, inorder.length);
        treeNode.left = buildTree(inorderLeftArray, postorderLeftArray);
        treeNode.right = buildTree(inorderRightArray, postorderRightArray);
        return treeNode;
    }
}
