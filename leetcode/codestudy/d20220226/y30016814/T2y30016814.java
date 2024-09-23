/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220226.y30016814;

import com.huawei.codestudy.d20220226.Main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 没有AC
 *
 * @author yijialuo
 * @since 2022/2/25 14:25
 */
public class T2y30016814 extends Main2 {
    @Override
    public int delDirectorys(String delDirNameBunch, String[] dirTreeLines) {
        Set<String> delDirName = Arrays.stream(delDirNameBunch.split(" ")).collect(Collectors.toUnmodifiableSet());
        Dir root = new Dir(dirTreeLines[0]);
        for (int i = 1; i < dirTreeLines.length; i++) {
            String[] dirSplit = dirTreeLines[i].split("\\|-");
            int level = dirSplit.length - 1;
            root.addDir(level, new Dir(dirSplit[dirSplit.length - 1]));
        }
        int count = 0;
        for (Dir dir : new ArrayList<>(root.child)) {
            count += dir.removeAndCount(delDirName, root.child);
        }
        return count;
    }

    private static class Dir {
        private final String name;
        private final LinkedList<Dir> child = new LinkedList<>();

        public Dir(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dir{" +
                "name='" + name + '\'' +
                '}';
        }

        private void addDir(int level, Dir dir) {
            if (level == 1) {
                child.addLast(dir);
            } else {
                Dir last = child.getLast();
                last.addDir(level - 1, dir);
            }
        }

        private boolean remove(Set<String> delDirName, LinkedList<Dir> preList) {
            if (delDirName.contains(name) && child.isEmpty()) {
                return preList.remove(this);
            } else {
                return false;
            }
        }

        private int removeAndCount(Set<String> delDirName, LinkedList<Dir> preList) {
            int count = 0;
            for (Dir dir : new ArrayList<>(this.child)) {
                if (dir.remove(delDirName, child)) {
                    count++;
                } else {
                    int temp = dir.removeAndCount(delDirName, this.child);
                    count += temp;
                }
            }
            if (delDirName.contains(name) && child.isEmpty()) {
                preList.remove(this);
                count++;
            }
            return count;
        }
    }
}
