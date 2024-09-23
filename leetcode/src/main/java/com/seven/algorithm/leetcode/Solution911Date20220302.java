package com.seven.algorithm.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * #### [911. 在线选举](https://leetcode-cn.com/problems/online-election/)
 * <p>
 * 给你两个整数数组 `persons` 和 `times` 。在选举中，第 `i` 张票是在时刻为 `times[i]` 时投给候选人 `persons[i]` 的。
 * <p>
 * 对于发生在时刻 `t` 的每个查询，需要找出在 `t` 时刻在选举中领先的候选人的编号。
 * <p>
 * 在 `t` 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 * <p>
 * 实现 `TopVotedCandidate` 类：
 * <p>
 * - `TopVotedCandidate(int[] persons, int[] times)` 使用 `persons` 和 `times` 数组初始化对象。
 * - `int q(int t)` 根据前面描述的规则，返回在时刻 `t` 在选举中领先的候选人的编号。
 * <p>
 * **示例：**
 * <p>
 * ```
 * 输入：
 * ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
 * [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
 * 输出：
 * [null, 0, 1, 1, 0, 0, 1]
 * <p>
 * 解释：
 * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
 * topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
 * topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
 * topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
 * topVotedCandidate.q(15); // 返回 0
 * topVotedCandidate.q(24); // 返回 0
 * topVotedCandidate.q(8); // 返回 1
 * ```
 * <p>
 * <p>
 * <p>
 * **提示：**
 * <p>
 * - `1 <= persons.length <= 5000`
 * - `times.length == persons.length`
 * - `0 <= persons[i] < persons.length`
 * - `0 <= times[i] <= 109`
 * - `times` 是一个严格递增的有序数组
 * - `times[0] <= t <= 109`
 * - 每个测试用例最多调用 `104` 次 `q`
 */
public class Solution911Date20220302 {

    /**
     * 执行用时：238 ms, 在所有 Java 提交中击败了9.36%的用户
     * 内存消耗：50.3 MB, 在所有 Java 提交中击败了5.04%的用户
     */
    static class TopVotedCandidate {
        private int[] times;
        private int[] max;
        private int[] persons;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            this.persons = persons;
            max = new int[times.length];
            HashMap<Integer, Integer> countMap = new HashMap<>();
            int maxNow = 0;
            for (int i = 0; i < persons.length; i++) {
                int orDefault = countMap.getOrDefault(persons[i], 0) + 1;
                if (orDefault > maxNow) {
                    maxNow = orDefault;
                    max[i] = persons[i];
                } else if (orDefault == maxNow) {
                    max[i] = persons[i];
                } else {
                    max[i] = max[i - 1];
                }
                countMap.put(persons[i], orDefault);
            }
        }

        public int q(int t) {
            int index = times.length - 1;
            for (int i = 0; i < times.length; i++) {
                if (times[i] > t) {
                    index = i - 1;
                    break;
                }
            }
            return max[index];
        }
    }
}
