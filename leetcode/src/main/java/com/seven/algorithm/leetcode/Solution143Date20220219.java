package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * #### [113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)
 * <p>
 * 难度中等669收藏分享切换为英文接收动态反馈
 * <p>
 * 给你二叉树的根节点 `root` 和一个整数目标和 `targetSum` ，找出所有 **从根节点到叶子节点** 路径总和等于给定目标和的路径。
 * <p>
 * *叶子节点** 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * *示例 1：**
 * <p>
 * ![img](https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg)
 * <p>
 * ```
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * ```
 * <p>
 * *示例 2：**
 * <p>
 * ![img](https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg)
 * <p>
 * ```
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * ```
 * <p>
 * *示例 3：**
 * <p>
 * ```
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * ```
 * <p>
 * <p>
 * <p>
 * *提示：**
 * <p>
 * - 树中节点总数在范围 `[0, 5000]` 内
 * - `-1000 <= Node.val <= 1000`
 * - `-1000 <= targetSum <= 1000`
 */
public class Solution143Date20220219 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return traverseNode(root, new ArrayList<Integer>(), targetSum);
    }

    private List<List<Integer>> traverseNode(TreeNode root, List<Integer> list, int targetSum) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        } else if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                list.add(root.val);
                lists.add(list);
            }
            return lists;
        } else {
            int targetTemp = targetSum - root.val;

            list.add(root.val);
            List<List<Integer>> leftRe = traverseNode(root.left, new ArrayList<>(list), targetTemp);
            if (!leftRe.isEmpty()){
                lists.addAll(leftRe);
            }
            List<List<Integer>> rightRe = traverseNode(root.right, new ArrayList<>(list), targetTemp);
            if (!rightRe.isEmpty()){
                lists.addAll(rightRe);
            }
            return lists;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
