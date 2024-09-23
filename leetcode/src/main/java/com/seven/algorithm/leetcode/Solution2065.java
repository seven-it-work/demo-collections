package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution2065 {
    public static void main(String[] args) {
        //     System.out.println(new Solution2065().maximalPathQuality(TransformUtils.intArrays("[0,32,10,43]"),
        //         TransformUtils.intTwoDimensionalArrays(" [[0,1,10],[1,2,15],[0,3,10]]"), 49));
        System.out.println(new Solution2065().maximalPathQuality(TransformUtils.intArrays("[1,2,3,4]"),
            TransformUtils.intTwoDimensionalArrays("[[0,1,10],[1,2,11],[2,3,12],[1,3,13]]"), 50));
    }

    private static Node toNode(int[] values, int[][] edges) {
        if (values.length == 0) {
            return null;
        }
        if (edges.length == 0) {
            return null;
        }
        Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            Node node = new Node();
            node.value = values[i];
            node.id = i;
            nodes[i] = node;
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Node start = nodes[edge[0]];
            Node end = nodes[edge[1]];
            int cost = edge[2];
            start.pathList.add(new Path(end, cost));
            end.pathList.add(new Path(start, cost));
        }
        return nodes[0];
    }

    private static int extracted(int maxTime, Node node, int value) {
        return 0;
    }

    /**
     * 0--1---2
     * \  /
     * 3
     * 暴力遍历路径
     * 0->1
     * 1->2
     * 1->3
     * 1->0
     * 2->1
     * 2->3
     * 3->1
     * 3->2
     * 每走一次 记录一次耗时，如果耗时大于maxTime就不走了，这条路作废
     *
     * @param values
     * @param edges
     * @param maxTime
     * @return
     */
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Node node = toNode(values, edges);
        if (node == null) {
            return 0;
        }
        return extracted(maxTime, node, 0);
    }

    private static class Path {
        private boolean isUsed = false;

        private Node node;

        private int cost;

        public Path(Node node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private static class Node {
        private int id;

        private int value;

        private List<Path> pathList = new ArrayList<>();
    }
}
