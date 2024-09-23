/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yijialuo
 * @since 2022/7/14 20:28
 */

public class Solution1600Date20220714 {
    @Test
    void case01() {
        ThroneInheritance t = new ThroneInheritance("king"); // 继承顺序：king
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder());
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        System.out.println(t.getInheritanceOrder());
    }

    class ThroneInheritance {
        final King king;

        final HashMap<String, King> kingMap = new HashMap<>();

        int start = 0;

        public ThroneInheritance(String kingName) {
            king = new King(kingName, start++);
            kingMap.put(kingName, king);
        }

        public void birth(String parentName, String childName) {
            final King king = kingMap.get(parentName);
            if (king == null) {
                return;
            }
            final King child = new King(childName, start++);
            king.birth(child);
            kingMap.put(childName, child);
        }

        public void death(String name) {
            final King king = kingMap.remove(name);
            if (king == null) {
                return;
            }
            king.isDead = true;
        }

        public List<String> getInheritanceOrder() {
            final List<String> order = king.getOrder();
            if (!king.isDead) {
                order.add(0, king.name);
            }
            return order;
        }

        private class King {
            private String name;

            private int age;

            private boolean isDead = false;

            private Map<String, King> child = new HashMap<>();

            public King(String name, int age) {
                this.name = name;
                this.age = age;
            }

            protected List<String> getOrder() {
                final ArrayList<String> result = new ArrayList<>();
                child.values()
                    .stream()
                    .sorted(Comparator.comparingInt(ch -> ch.age))
                    .forEach(kingTemp -> {
                        if (!kingTemp.isDead) {
                            result.add(kingTemp.name);
                        }
                        result.addAll(kingTemp.getOrder());
                    });
                return result;
            }

            private void birth(King king) {
                child.put(king.name, king);
            }
        }
    }
}
