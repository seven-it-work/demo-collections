/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220318.y30016814;

import com.huawei.codestudy.d20220318.Main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 情况1 第一个是儿童 他应该选择成人桌子 还是儿童桌子呢？？！！
 *
 * @author yijialuo
 * @since 2022/3/22 14:10
 */
public class Main2Y30016814 extends Main2 {

    /**
     * 如果是儿童先进入，那么儿童优先去儿童桌等待！
     * 这个方法考虑的场景时，儿童在外面等着，不占座，如果下一个是成人那么就去成人桌，否则去儿童桌
     *
     * @param num 围棋桌子数量
     * @param cnt 儿童桌子数量
     * @param time 对弈时间
     * @param people 人员列表{入场时间,人员类型(0大人，1儿童)}
     * @return 每人开始对弈的时间
     */
    public int[] goGameError(int num, int cnt, int time, int[][] people) {
        int chen = num - cnt;
        int[] result = new int[people.length];
        Arrays.fill(result, -1);
        List<Who2Who> who2WhoList = new LinkedList<>();
        Who2Who wait = null;
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            if (wait == null) {
                wait = new Who2Who(person[1], i, person[0]);
            } else {
                // 检测对弈是否有结束的
                if (!who2WhoList.isEmpty()) {
                    for (int index = 0; index < who2WhoList.size(); index++) {
                        Who2Who who2Who = who2WhoList.get(index);
                        if (who2Who.isOver(person[0], time)) {
                            // 更新result
                            result[who2Who.people1Id] = who2Who.getStartTime();
                            result[who2Who.people2Id] = who2Who.getStartTime();
                            // 还原座位数量
                            if (who2Who.type == 1) {
                                cnt++;
                            } else {
                                chen++;
                            }
                        } else {
                            who2WhoList = who2WhoList.subList(index, who2WhoList.size());
                            break;
                        }
                    }
                }
                wait.type = Math.min(wait.type, person[1]);
                // 判断是否能对弈
                if (wait.type == 1 && cnt > 0) {
                    // 儿童对弈
                    wait.addPeople(i, person[0]);
                    who2WhoList.add(wait);
                    wait = null;
                    cnt--;
                } else if (wait.type == 1 && chen > 0) {
                    // 没有儿童桌了，儿童两个去成人桌对弈
                    wait.addPeople(i, person[0]);
                    who2WhoList.add(wait);
                    wait = null;
                    chen--;
                } else if (wait.type == 0 && chen > 0) {
                    // 成人桌对弈
                    wait.addPeople(i, person[0]);
                    who2WhoList.add(wait);
                    wait = null;
                    chen--;
                } else {
                    // 桌子不够了，无法对弈，这两人离开
                    wait = null;
                }
            }
        }
        // 更新开始时间
        for (Who2Who who2Who : who2WhoList) {
            // 更新result
            result[who2Who.people1Id] = who2Who.getStartTime();
            result[who2Who.people2Id] = who2Who.getStartTime();
        }
        return result;
    }

    @Override
    public int[] goGame(int num, int cnt, int time, int[][] people) {
        int chen = num - cnt;
        int[] result = new int[people.length];
        Arrays.fill(result, -1);
        List<Who2Who> who2WhoList = new ArrayList<>();
        LinkedList<Who2Who> waitLinked = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            // 检测是否下完了
            if (!who2WhoList.isEmpty()) {
                int subEnd = 0;
                for (int index = 0; index < who2WhoList.size(); index++) {
                    Who2Who who2Who = who2WhoList.get(index);
                    if (who2Who.isOver(person[0], time)) {
                        // 更新result
                        result[who2Who.people1Id] = who2Who.getStartTime();
                        result[who2Who.people2Id] = who2Who.getStartTime();
                        // 还原座位数量
                        if (who2Who.type == 1) {
                            cnt++;
                        } else {
                            chen++;
                        }
                    } else {
                        break;
                    }
                    subEnd = index + 1;
                }
                who2WhoList = who2WhoList.subList(subEnd, who2WhoList.size());
            }
            // 抢桌子
            if (person[1] == 1) {
                if (waitLinked.isEmpty()) {
                    if (cnt > 0) {
                        // 霸占儿童桌
                        waitLinked.add(new Who2Who(1, i, person[0]));
                        cnt--;
                        // 小孩能不能占成桌？ 题目不太清晰~
                        // } else if (chen > 0) {
                        //     // 霸占成人桌
                        //     waitLinked.add(new Who2Who(0, i, person[0]));
                        //     chen--;
                    } else {
                        // 无桌子可用
                        System.out.println("无桌子可用！");
                    }
                } else {
                    Who2Who first = waitLinked.removeFirst();
                    first.addPeople(i, person[0]);
                    who2WhoList.add(first);
                }
            } else {
                // 成人
                if (waitLinked.isEmpty()) {
                    if (chen > 0) {
                        // 霸占成人桌
                        waitLinked.add(new Who2Who(0, i, person[0]));
                        chen--;
                    } else {
                        // 无桌子可用
                        System.out.println("无桌子可用！");
                    }
                } else {
                    boolean isFind = false;
                    Iterator<Who2Who> iterator = waitLinked.iterator();
                    while (iterator.hasNext()) {
                        Who2Who next = iterator.next();
                        if (next.type == 0) {
                            // 成人桌
                            iterator.remove();
                            next.addPeople(i, person[0]);
                            who2WhoList.add(next);
                            isFind = true;
                            break;
                        }
                    }
                    if (!isFind && chen > 0) {
                        // 霸占成人桌
                        waitLinked.add(new Who2Who(0, i, person[0]));
                        chen--;
                    }
                }
            }
        }

        // 更新开始时间
        for (Who2Who who2Who : who2WhoList) {
            // 更新result
            result[who2Who.people1Id] = who2Who.getStartTime();
            result[who2Who.people2Id] = who2Who.getStartTime();
        }
        return result;
    }

    static class Who2Who {
        // 0表示成人桌子 1表示儿童桌子
        private int type;
        // 对弈人员索引1
        private int people1Id;
        private int startTime1;
        // 对弈人员索引2
        private int people2Id;
        private int startTime2;

        public Who2Who(int type, int people1Id, int startTime1) {
            this.type = type;
            this.people1Id = people1Id;
            this.startTime1 = startTime1;
        }

        public void addPeople(int people2Id, int startTime2) {
            this.people2Id = people2Id;
            this.startTime2 = startTime2;
        }

        @Override
        public String toString() {
            return "Who2Who{" +
                "type=" + type +
                ", people1Id=" + people1Id +
                ", startTime1=" + startTime1 +
                ", people2Id=" + people2Id +
                ", startTime2=" + startTime2 +
                '}';
        }

        public boolean isOver(int timeNow, int time) {
            return timeNow >= getStartTime() + time;
        }

        public int getStartTime() {
            return Math.max(startTime1, startTime2);
        }
    }

}
