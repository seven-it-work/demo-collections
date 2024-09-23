/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220318.h30022790;

import com.huawei.codestudy.d20220318.Main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Question2 extends Main2 {
    @Override
    public int[] goGame(int num, int cnt, int time, int[][] people) {
        int[] result = new int[people.length];
        Arrays.fill(result, -1);
        List<Table> tableParent = new ArrayList<>();
        List<Table> tableChild = new ArrayList<>();
        for (int peopleId = 0; peopleId < people.length; peopleId++) {
            clearTimeoutTables(time, people[peopleId], tableParent, tableChild);
            if (people[peopleId][1] == 0) {
                parentComeIn(num - cnt, people, peopleId, result, tableParent);
                continue;
            }
            childComeIn(num, cnt, people, peopleId, result, tableParent, tableChild);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * 小孩进来
     */
    private void childComeIn(int num, int cnt, int[][] people, int peopleId, int[] result, List<Table> tableParent,
        List<Table> tableChild) {
        Table waitingChild = findWaitingTable(tableChild, Table::isWaiting);
        if (waitingChild != null) {
            waitingChild.addPlayer(peopleId, people[peopleId][0]);
            waitingChild.startGame(result);
            return;
        }
        Table waitingParent = findWaitingTable(tableParent, Table::isWaiting);
        if (waitingParent != null) {
            waitingParent.addPlayer(peopleId, people[peopleId][0]);
            waitingParent.startGame(result);
            return;
        }
        if (tableChild.size() < cnt) {
            tableChild.add(new Table(peopleId, people[peopleId][1], people[peopleId][0]));
            return;
        }
        if (tableParent.size() < num - cnt) {
            tableParent.add(new Table(peopleId, people[peopleId][1], people[peopleId][0]));
        }
    }

    /**
     * 家长进来
     */
    private void parentComeIn(int tableCapacity, int[][] people, int peopleId, int[] result, List<Table> tableParent) {
        Table waiting = findWaitingTable(tableParent, table -> table.isWaiting() && table.isParentWaiting());
        if (waiting == null) {
            if (tableParent.size() < tableCapacity) {
                tableParent.add(new Table(peopleId, people[peopleId][1], people[peopleId][0]));
            }
            return;
        }
        waiting.addPlayer(peopleId, people[peopleId][0]);
        waiting.startGame(result);
    }

    /**
     * 清除超时的对局
     */
    private void clearTimeoutTables(int time, int[] person, List<Table> tableParent, List<Table> tableChild) {
        tableParent.removeIf(table -> table.isGaming() && person[0] - table.getStartTime() >= time);
        tableChild.removeIf(table -> table.isGaming() && person[0] - table.getStartTime() >= time);
    }

    /**
     * 查找最早等待的那个人所在的桌子
     */
    private Table findWaitingTable(List<Table> tables, Predicate<Table> predicate) {
        return tables.stream()
            .filter(predicate)
            .min((o1, o2) -> o1.getFirstWaitPersonEnterTime() == o2.getFirstWaitPersonEnterTime()
                ? o1.getFirstWaitPersonId() - o2.getFirstWaitPersonId()
                : o1.getFirstWaitPersonEnterTime() - o2.getFirstWaitPersonEnterTime())
            .orElse(null);
    }

    static class Table {
        private final int firstWaitPersonId;
        private final int firstWaitPersonType;
        private final int firstWaitPersonEnterTime;
        private int secondWaitPersonId;
        private int secondWaitPersonEnterTime;
        private int tableStatus;  // 1对弈中 0等待中

        public Table(int firstWaitPersonId, int firstWaitPersonType, int firstWaitPersonEnterTime) {
            this.firstWaitPersonId = firstWaitPersonId;
            this.firstWaitPersonType = firstWaitPersonType;
            this.firstWaitPersonEnterTime = firstWaitPersonEnterTime;
            this.tableStatus = 0;
        }

        public boolean isParentWaiting() {
            return firstWaitPersonType == 0;
        }

        public boolean isWaiting() {
            return tableStatus == 0;
        }

        public boolean isGaming() {
            return tableStatus == 1;
        }

        public void startGame(int[] result) {
            this.tableStatus = 1;
            result[this.firstWaitPersonId] = this.secondWaitPersonEnterTime;
            result[this.secondWaitPersonId] = this.secondWaitPersonEnterTime;
        }

        public int getFirstWaitPersonId() {
            return firstWaitPersonId;
        }

        public int getFirstWaitPersonEnterTime() {
            return firstWaitPersonEnterTime;
        }

        public int getStartTime() {
            return this.secondWaitPersonEnterTime;
        }

        public void addPlayer(int secondWaitPersonId, int secondWaitPersonEnterTime) {
            this.secondWaitPersonId = secondWaitPersonId;
            this.secondWaitPersonEnterTime = secondWaitPersonEnterTime;
        }
    }
}
