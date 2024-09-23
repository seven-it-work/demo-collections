package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution2742 {
    public static void main(String[] args) {
        System.out.println(new Solution2742().paintWalls(new int[] {1, 2, 3, 2}, new int[] {1, 2, 3, 2}));// 3
        System.out.println(new Solution2742().paintWalls(new int[] {2,3,4,2}, new int[] {1,1,1,1}));// 4
        System.out.println(new Solution2742().paintWalls(new int[] {26,53,10,24,25,20,63,51}, new int[] {1,1,1,1,2,2,2,1}));// 55
    }
    /**
     * 付费先去找最低的cost，免费去早最高的cost
     * 如果两个时间一样则重复运行
     * 如果付费时间>免费 记录付费多的工作时间
     * 如果付费时间<免费 付费再去找
     *
     * @param cost
     * @param time
     * @return
     */
    public int paintWalls(int[] cost, int[] time) {
        ArrayList<Wall> walls = new ArrayList<>();
        for (int i = 0; i < cost.length; i++) {
            walls.add(new Wall(cost[i], time[i], false, i));
        }
        walls.sort(Comparator.comparingDouble(Wall::unitPrice));
        int pay = 0;
        int payIndex = 0;
        int freeIndex = cost.length - 1;
        int moreTime = 0;
        while (true) {
            if (moreTime <= 0) {
                Wall wall = walls.get(payIndex);
                if (wall.used) {
                    break;
                }
                moreTime += wall.time;
                wall.used = true;
                pay += wall.cost;
                payIndex++;
            } else {
                Wall wall = walls.get(freeIndex);
                if (wall.used) {
                    break;
                }
                wall.used = true;
                moreTime--;
                freeIndex--;
            }
        }
        return pay;
    }

    private static class Wall {
        private int cost;

        private int time;

        private boolean used;

        private int index;

        public Wall(int cost, int time, boolean used, int index) {
            this.cost = cost;
            this.time = time;
            this.used = used;
            this.index = index;
        }
        private double unitPrice(){
            return this.cost/this.time;
        }
    }

}
