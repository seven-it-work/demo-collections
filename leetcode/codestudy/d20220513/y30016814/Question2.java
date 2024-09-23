/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220513.y30016814;

import com.huawei.codestudy.d20220513.Main2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 耗时：57min
 * 代码写的乱。。。不忍直视！
 *
 * @author yijialuo
 * @since 2022/5/20 9:53
 */
public class Question2 extends Main2 {
    @Override
    public List<int[]> getRecruitmentResults(List<DeptDemand> deptDemands, List<Candidate> candidateAbilities) {
        // 部门编号排序
        final List<BestDeptDemand> sortDeptDemands = deptDemands.stream()
            .sorted(Comparator.comparingInt(o -> o.id))
            .map(BestDeptDemand::new)
            .collect(Collectors.toList());
        final List<BestCandidate> bestCandidateList = candidateAbilities.stream()
            .map(BestCandidate::new)
            .collect(Collectors.toList());
        // 1. 增加候选名单
        sortDeptDemands.forEach(bestDeptDemand -> {
            for (int i = 0; i < bestCandidateList.size(); i++) {
                final BestCandidate candidate = bestCandidateList.get(i);
                candidate.id = i;
                bestDeptDemand.addShortlist(candidate);
            }
        });
        // 2. 执行应聘
        sortDeptDemands.forEach(BestDeptDemand::executeRecruitment);
        sortDeptDemands.forEach(BestDeptDemand::executeRecruitment);
        sortDeptDemands.forEach(BestDeptDemand::executeRecruitment);
        return sortDeptDemands.stream().map(BestDeptDemand::getRecruitedIndex).collect(Collectors.toList());
    }

    private static class BestCandidate extends Candidate implements Comparable<Candidate> {
        private boolean hasBeenApplied = false;

        public BestCandidate(int id, int[] grades) {
            super(id, grades);
        }

        public BestCandidate(Candidate candidate) {
            super(candidate.id, new int[] {candidate.progmGrade, candidate.techGrade});
        }

        @Override
        public int compareTo(Candidate o) {
            if (this.techGrade != o.techGrade) {
                return o.techGrade - this.techGrade;
            }
            if (this.progmGrade != o.progmGrade) {
                return o.progmGrade - this.progmGrade;
            }
            return this.id - o.id;
        }

        private void applied() {
            this.hasBeenApplied = true;
        }
    }

    private static class BestDeptDemand extends DeptDemand {
        private final List<Integer> recruitedIndex;
        private final Map<Integer, BestCandidate> indexAndCandidates;

        public BestDeptDemand(int id, int[] arr) {
            super(id, arr);
            this.recruitedIndex = new ArrayList<>();
            indexAndCandidates = new HashMap<>();
        }

        public BestDeptDemand(DeptDemand deptDemand) {
            super(deptDemand.id, new int[] {deptDemand.employNum, deptDemand.progmThd, deptDemand.techThd});
            this.recruitedIndex = new ArrayList<>();
            indexAndCandidates = new HashMap<>();
        }

        public void addShortlist(BestCandidate candidate) {
            if (this.satisfiedOrNot(candidate)) {
                indexAndCandidates.put(candidate.id, candidate);
            }
        }

        public void executeRecruitment() {
            final BestCandidate bestCandidate = indexAndCandidates.values()
                .stream()
                .filter(candidate -> !candidate.hasBeenApplied)
                .sorted()
                .findFirst()
                .orElse(null);
            if (bestCandidate != null && recruitedIndex.size() < employNum) {
                bestCandidate.applied();
                recruitedIndex.add(bestCandidate.id);
                indexAndCandidates.remove(bestCandidate.id);
            }
        }

        private boolean satisfiedOrNot(Candidate candidate) {
            return progmThd <= candidate.progmGrade && techThd <= candidate.techGrade;
        }

        private int[] getRecruitedIndex() {
            return recruitedIndex.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
