/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */
package com.seven.algorithm.utils;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.seven.algorithm.utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TransformUtils {
    public static void main(String[] args) {
        // System.out.println((arrays2Node("[1,2,2,3,3,null,null,4,4]")));
        System.out.println((arrays2TreeNode("[1,2,2,3,null,null,3,4,null,null,4]")));
    }

    public static ListNode arrays2ListNode(String nodeInts) {
        return arrays2ListNode(nodeIntsStr2IntegerArray(nodeInts));
    }

    public static ListNode arrays2ListNode(Integer[] array) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        for (Integer integer : array) {
            next.next = new ListNode(integer);
            next = next.next;
        }
        return head.next;
    }

    private static Integer[] nodeIntsStr2IntegerArray(String nodeInts) {
        JSONArray objects = JSONUtil.parseArray(nodeInts);
        Integer[] integers = new Integer[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            Object o = objects.get(i);
            if (o == null || o.equals("null")) {
                integers[i] = null;
            }
            integers[i] = objects.getInt(i);
        }
        return integers;
    }

    public static TreeNode arrays2TreeNode(String nodeInts) {
        return arrays2TreeNode(nodeIntsStr2IntegerArray(nodeInts));
    }

    public static TreeNode arrays2TreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        // 创建第一个结点
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        // 遍历子结点的方向
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            // 取出队尾元素
            TreeNode node = deque.getLast();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    deque.addFirst(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    deque.addFirst(node.right);
                }
                // 删除队尾元素
                deque.removeLast();
                isLeft = true;
            }
        }
        return root;
    }

    public static String showArrays(int[] ints) {
        return JSONUtil.toJsonStr(ints);
    }

    public static String showArrays(int[][] ints) {
        return JSONUtil.toJsonStr(ints);
    }

    public static int[] intArrays(String str) {
        return JSONUtil.parseArray(str).stream().mapToInt(obj -> (int) obj).toArray();
    }

    public static int[][] intTwoDimensionalArrays(String str) {
        List<List<Integer>> collect = JSONUtil.parseArray(str)
                .stream()
                .map(obj -> ((JSONArray) obj).toList(Integer.class))
                .collect(Collectors.toList());
        int[][] ints = new int[collect.size()][0];
        for (int i = 0; i < collect.size(); i++) {
            ints[i] = collect.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return ints;
    }

    public static char[][] charTwoDimensionalArrays(String str) {
        List<List<Character>> collect = JSONUtil.parseArray(str)
                .stream()
                .map(obj -> ((JSONArray) obj).toList(Character.class))
                .collect(Collectors.toList());
        char[][] result = new char[collect.size()][0];
        for (int i = 0; i < collect.size(); i++) {
            result[i] = collect.get(i).stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
        }
        return result;
    }
}
