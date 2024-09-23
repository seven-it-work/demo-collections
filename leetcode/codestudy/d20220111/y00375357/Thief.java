package com.huawei.codestudy.d20220111.y00375357;

import com.huawei.codestudy.d20220111.T2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Thief extends T2 {
    @Override
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());

        return getRobMoney(collect, true);
    }

    private int getRobMoney(List<Integer> canRobMoney, boolean isFirst) {
        if (canRobMoney.size() == 0) {
            return 0;
        }
        if (canRobMoney.size() == 1) {
            return canRobMoney.get(0);
        }
        if (canRobMoney.size() == 2) {
            return Math.max(canRobMoney.get(0), canRobMoney.get(1));
        }

        int robTotal = 0;
        List<Integer> selectList = new ArrayList<>();
        selectList.addAll(canRobMoney);
        List<Integer> unSelectList = new ArrayList<>();
        unSelectList.addAll(canRobMoney);

        unSelectList.remove(0);
        selectList.remove(1);
        selectList.remove(0);
        if (isFirst) {
            selectList.remove(selectList.size() - 1);
        }

        robTotal = Math.max(robTotal,
            Math.max(canRobMoney.get(0) + getRobMoney(selectList, false), getRobMoney(unSelectList, false)));

        return robTotal;
    }

    public static void main(String[] args) {
        Thief thief = new Thief();
        int[] a = {1, 2, 1, 1};
        System.out.println(thief.rob(a));

    }
}
