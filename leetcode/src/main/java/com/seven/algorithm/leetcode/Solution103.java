package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;
import com.seven.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution103 {
    public static void main(String[] args) {
        System.out.println(new Solution103().zigzagLevelOrder(TransformUtils.arrays2TreeNode("[1,2,3,4,null,null,5]")));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> data = new HashMap<>();
        this.doIt(root, 1, data);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        data.forEach((key,value)->{
            if (key%2==1){
                Collections.reverse(value);
            }
            lists.add(value);
        });
        return lists;
    }

    private void doIt(TreeNode root, int level, HashMap<Integer, List<Integer>> data) {
        if (root==null){
            return;
        }
        List<Integer> orDefault = data.getOrDefault(level, new ArrayList<>());
        orDefault.add(root.val);
        data.put(level, orDefault);
        if (root.right != null) {
            doIt(root.right, level + 1, data);
        }
        if (root.left != null) {
            doIt(root.left, level + 1, data);
        }
    }
}
