/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203.y30016814;

import com.huawei.codestudy.d20211203.base.BaseT3d20211203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 第三题
 *
 * @author y30016814
 * @since 2021/12/25 16:59
 */
public class T3y30016814 extends BaseT3d20211203 {
    /**
     * 如果index 较大仍然有超时风险
     *
     * @param nums 密码组
     * @param index 倒数第index个
     * @return 密码
     */
    @Override
    public int findPassword(int[][] nums, int index) {
        if (nums.length < 2) {
            return nums[0][index - 1];
        }
        List<Integer> collect = Arrays.stream(nums[0]).boxed().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        List<Integer> integers = addListMax(collect, nums[1], index);
        for (int i = 2; i < nums.length; i++) {
            integers = addListMax(integers, nums[i], index);
        }
        return integers.get(index - 1);
    }

    private List<Integer> addListMax(List<Integer> list, int[] nums, int index) {
        LinkedList<Integer> result = new LinkedList<>();
        for (Integer integer : list) {
            result.add(integer + nums[nums.length - 1]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            result.sort((o1, o2) -> o2 - o1);
            Integer last = result.peekLast();
            Boolean isGoOn = null;
            for (Integer integer : list) {
                int temp = integer + nums[i];
                if (temp >= last) {
                    result.add(temp);
                    isGoOn = true;
                } else if (isGoOn == null) {
                    isGoOn = false;
                    break;
                }
            }
            if (isGoOn != null && !isGoOn) {
                break;
            }
        }
        return getPreIndex(result, index);
    }

    private List<Integer> getPreIndex(List<Integer> list, int preIndex) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < Math.min(list.size(), preIndex); i++) {
            integers.add(list.get(i));
        }
        return integers;
    }
}
