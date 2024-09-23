/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220318.h30022790;

import com.huawei.codestudy.d20220318.Main1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question1 extends Main1 {

    private int[][] materials;

    private int[][] products;

    private int materialsNum;

    @Override
    public void inventorySystem(int materialsNum, int[][] products) {
        this.materialsNum = materialsNum;
        this.products = products;
        this.materials = new int[materialsNum][2];
        IntStream.range(0, materialsNum).forEach(i -> this.materials[i][0] = i);
    }

    @Override
    public void purchase(int[][] materials) {
        Arrays.stream(materials).forEach(material -> this.materials[material[0]][1] += material[1]);
    }

    @Override
    public boolean produce(int[] productIds) {
        Map<Integer, Integer> needMap = Arrays.stream(productIds)
            .boxed()
            .collect(Collectors.toMap(productId -> productId, productId -> 1, Integer::sum));
        int[] allNeeds = new int[this.materialsNum];
        needMap.forEach((prod, nums) ->
            IntStream.range(0, this.products[prod].length).forEach(i -> allNeeds[i] += this.products[prod][i] * nums));
        for (int i = 0; i < this.materials.length; i++) {
            if (allNeeds[i] > this.materials[i][1]) {
                return false;
            }
        }
        IntStream.range(0, this.materials.length).forEach(i -> this.materials[i][1] -= allNeeds[i]);
        return true;
    }

    @Override
    public int queryMin() {
        Optional<int[]> minOpt = Arrays.stream(this.materials).min(Comparator.comparingInt(a -> a[1]));
        return minOpt.map(ints ->
            Arrays.stream(this.materials)
                .filter(material -> material[1] == ints[1])
                .findFirst()
                .map(material -> material[0])
                .orElse(0))
            .orElse(0);
    }
}
