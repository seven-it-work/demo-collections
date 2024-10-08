package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
 * <p>
 * 难度困难1417收藏分享切换为英文接收动态反馈
 * <p>
 * **路径** 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 **至多出现一次** 。该路径 **至少包含一个** 节点，且不一定经过根节点。
 * <p>
 * **路径和** 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 `root` ，返回其 **最大路径和** 。
 * <p>
 * <p>
 * <p>
 * **示例 1：**
 * <p>
 * ![img](https://sevenpic.oss-cn-beijing.aliyuncs.com/img/exx1.jpg)
 * <p>
 * ```
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * ```
 * <p>
 * **示例 2：**
 * <p>
 * ![img](https://sevenpic.oss-cn-beijing.aliyuncs.com/img/exx2.jpg)
 * <p>
 * ```
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * ```
 * <p>
 * <p>
 * <p>
 * **提示：**
 * <p>
 * - 树中节点数目范围是 `[1, 3 * 104]`
 * - `-1000 <= Node.val <= 1000`
 */
public class Solution124Date20220219 {
    public int maxPathSum(TreeNode root) {

        return 0;
    }

    /**
     * 官方题解
     */
    public static class SolutionOfficial {
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        public int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }
            // 递归计算左右子节点的最大贡献值
            // 只有在最大贡献值大于 0 时，才会选取对应子节点
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);
            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            int priceNewpath = node.val + leftGain + rightGain;
            // 更新答案
            maxSum = Math.max(maxSum, priceNewpath);
            // 返回节点的最大贡献值
            return node.val + Math.max(leftGain, rightGain);
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
