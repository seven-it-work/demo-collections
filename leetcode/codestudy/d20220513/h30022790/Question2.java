/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220513.h30022790;

import com.huawei.codestudy.d20220513.Main2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question2 extends Main2 {
    @Override
    public List<int[]> getRecruitmentResults(List<DeptDemand> deptDemands, List<Candidate> candidateAbilities) {
        sortCandidates(candidateAbilities);
        Map<Integer, List<Integer>> deptMap = IntStream.range(0, deptDemands.size())
            .boxed()
            .collect(Collectors.toMap(i -> i, i -> new ArrayList<>(), (a, b) -> b, TreeMap::new));
        List<Integer> selected = firstLoop(deptDemands, candidateAbilities, deptMap);
        secondLoop(candidateAbilities, deptMap, selected);
        return deptMap.values()
            .stream()
            .map(integers -> integers.stream().mapToInt(data -> data).toArray())
            .collect(Collectors.toList());
    }

    private static void sortCandidates(List<Candidate> candidateAbilities) {
        candidateAbilities.sort((o1, o2) -> {
            if (o1.techGrade != o2.techGrade) {
                return o2.techGrade - o1.techGrade;
            }
            if (o1.progmGrade != o2.progmGrade) {
                return o2.progmGrade - o1.progmGrade;
            }
            return o1.id - o2.id;
        });
    }

    private static void secondLoop(List<Candidate> candidateAbilities, Map<Integer, List<Integer>> deptMap,
        List<Integer> selected) {
        List<Candidate> collect = candidateAbilities.stream()
            .filter(person -> !selected.contains(person.id))
            .collect(Collectors.toList());
        List<Integer> lastSelected = new ArrayList<>();
        deptMap.values()
            .stream()
            .filter(all -> all.size() > 0)
            .forEach(all -> secondSelect(candidateAbilities, collect, lastSelected, all));
    }

    private static void secondSelect(List<Candidate> candidateAbilities, List<Candidate> collect,
        List<Integer> lastSelected, List<Integer> all) {
        Candidate last = candidateAbilities.stream()
            .filter(candidate -> candidate.id == all.get(all.size() - 1))
            .findFirst().orElse(null);
        if (last == null) {
            return;
        }
        List<Candidate> lastCandidates = collect.stream()
            .filter(person -> !lastSelected.contains(person.id))
            .collect(Collectors.toList());
        for (Candidate candidate : lastCandidates) {
            if (candidate.progmGrade == last.progmGrade && candidate.techGrade == last.techGrade) {
                all.add(candidate.id);
                lastSelected.add(candidate.id);
                break;
            }
        }
    }

    private static List<Integer> firstLoop(List<DeptDemand> deptDemands, List<Candidate> candidateAbilities,
        Map<Integer, List<Integer>> deptMap) {
        List<Integer> selected = new ArrayList<>();
        boolean isFinished = false;
        while (!isFinished) {
            isFinished = firstLoopIsFinished(deptDemands, candidateAbilities, deptMap, selected, isFinished);
        }
        return selected;
    }

    private static boolean firstLoopIsFinished(List<DeptDemand> deptDemands, List<Candidate> candidateAbilities,
        Map<Integer, List<Integer>> deptMap, List<Integer> selected, boolean isFinished) {
        int unFinishedCount = 0;
        for (DeptDemand deptDemand : deptDemands) {
            if (deptDemand.employNum <= 0) {
                continue;
            }
            List<Integer> persons = deptMap.get(deptDemand.id);
            List<Candidate> collect = candidateAbilities.stream()
                .filter(person -> !selected.contains(person.id))
                .collect(Collectors.toList());
            boolean isSelect = false;
            for (Candidate candidate : collect) {
                if (isSelect) {
                    break;
                }
                if (candidate.progmGrade < deptDemand.progmThd || candidate.techGrade < deptDemand.techThd) {
                    continue;
                }
                persons.add(candidate.id);
                selected.add(candidate.id);
                deptDemand.employNum--;
                if (deptDemand.employNum > 0) {
                    unFinishedCount++;
                }
                isSelect = true;
            }
        }
        if (unFinishedCount == 0) {
            isFinished = true;
        }
        return isFinished;
    }
}
