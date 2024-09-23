/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220513;

import java.util.List;
import java.util.Locale;

public abstract class Main2 {
    public abstract List<int[]> getRecruitmentResults(List<DeptDemand> deptDemands, List<Candidate> candidateAbilities);

    public static class Candidate {
        public int id;
        public int progmGrade; // 机试分数
        public int techGrade;  // 技面分数

        public Candidate(int id, int[] grades) {
            this.id = id;
            this.progmGrade = grades[0];
            this.techGrade = grades[1];
        }

        public String toString() {
            return String.format(Locale.ROOT, "{%d : %d %d}",
                this.id, this.progmGrade, this.techGrade);
        }
    }

    public static class DeptDemand {
        public int id = -1;
        public int employNum = 0; // 招聘目标
        public int progmThd = 0;  // 机考门槛值
        public int techThd = 0;   // 技面门槛值

        public DeptDemand(int id, int[] arr) {
            this.id = id;
            this.employNum = arr[0];
            this.progmThd = arr[1];
            this.techThd = arr[2];
        }

        public String toString() {
            return String.format(Locale.ROOT, "{%d : %d %d %d}",
                this.id, this.employNum, this.progmThd, this.techThd);
        }
    }
}
