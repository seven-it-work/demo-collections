package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;
import com.seven.algorithm.utils.TreeNode;

import java.util.Arrays;

/**
 *
 */
public class Solution105 {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(Arrays.copyOfRange(new int[] {1, 2}, 0, 2)));
        TreeNode treeNode = new Solution105().buildTree(TransformUtils.intArrays("[3,9,20,15,7]"),
            TransformUtils.intArrays("[9,3,15,20,7]"));
        // System.out.println(
        //     new Solution105().buildTree(TransformUtils.intArrays("[1,2,3]"), TransformUtils.intArrays("[3,2,1]")));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int preorderRootIndex = 0;
        int inorderRootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preorderRootIndex]) {
                inorderRootIndex = i;
                break;
            }
        }
        if (inorderRootIndex == -1) {
            throw new RuntimeException("错误了");
        }
        // 找到中序往前的长度，就是左树
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, inorderRootIndex);
        TreeNode treeNode = new TreeNode(preorder[preorderRootIndex]);
        treeNode.left = buildTree(
            Arrays.copyOfRange(preorder, preorderRootIndex + 1, preorderRootIndex + 1 + leftInorder.length),
            leftInorder);
        // 找到中序往后的长度，就是右树
        int[] rightInorder = Arrays.copyOfRange(inorder, inorderRootIndex + 1, inorder.length);
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, preorder.length - rightInorder.length, preorder.length),
            rightInorder);
        return treeNode;
    }
}
