package com.huawei.codestudy.d20220111.y00375357;

import com.huawei.codestudy.d20220111.T3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DistancePair extends T3 {
    @Override
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (i == j) {
                    continue;
                }
                if (!handleDistancePair(result, Math.abs(nums[i] - nums[j]), k)) {
                    break;
                }
            }
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (!handleDistancePair(result, Math.abs(nums[i] - nums[j]), k)) {
                    break;
                }
            }
        }

        return result.get(result.size() - 1);
    }

    public boolean handleDistancePair(List<Integer> result, int dis, int k) {
        if (result.size() < k - 1) {
            result.add(Math.abs(dis));
        } else if (result.size() == k - 1) {
            result.add(Math.abs(dis));
            result.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        } else {
            if (dis >= result.get(result.size() - 1)) {
                return false;
            }
            int index = getAddIndex(result, dis);
            result.add(index, dis);
            result.remove(result.size() - 1);
        }

        return true;
    }

    private int getAddIndex(List<Integer> result, int dis) {
        int begin = 0;
        int end = result.size();
        int index = (0 + end) / 2;
        while (true) {
            if (result.get(index) == dis) {
                return index;
            } else if (result.get(index) > dis) {
                if (index == (begin + index) / 2) {
                    return index;
                }
                end = index;
                index = (begin + index) / 2;

            } else {
                if (index == (index + end) / 2) {
                    return index;
                }
                begin = index;
                index = (index + end) / 2;
            }
        }
    }

    public static void main(String[] args) {
        DistancePair distancePair = new DistancePair();

        int[] dis = new int[1000];
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            dis[i] = Math.abs(random.nextInt());
        }

        int k = 580 * 1000 / 2;
        System.out.println(distancePair.smallestDistancePair(dis, k));
    }
}
