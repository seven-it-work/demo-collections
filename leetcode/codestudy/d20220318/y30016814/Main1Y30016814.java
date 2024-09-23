/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220318.y30016814;

import com.huawei.codestudy.d20220318.Main1;

import java.util.HashMap;

/**
 * @author yijialuo
 * @since 2022/3/21 16:04
 */
public class Main1Y30016814 extends Main1 {
    // 物料编号，和数量
    HashMap<Integer, Integer> materialsIdAndNumber = new HashMap<>();
    // 产品编号，需要数量
    HashMap<Integer, int[]> materialsIdAndNeedNumber = new HashMap<>();

    /**
     * @param products products[产品i][物料j的数量]
     */
    @Override
    public void inventorySystem(int materialsNum, int[][] products) {
        for (int i = 0; i < products.length; i++) {
            materialsIdAndNeedNumber.put(i, products[i]);
        }
        for (int i = 0; i < materialsNum; i++) {
            materialsIdAndNumber.put(i, 0);
        }
    }

    @Override
    public void purchase(int[][] materials) {
        // 是否存在物料id不存在场景？
        for (int[] material : materials) {
            materialsIdAndNumber.put(material[0], materialsIdAndNumber.get(material[0]) + material[1]);
        }
    }

    @Override
    public boolean produce(int[] productIds) {
        HashMap<Integer, Integer> temp = new HashMap<>(materialsIdAndNumber);
        for (int productId : productIds) {
            if (!produce(productId, temp)) {
                return false;
            }
        }
        materialsIdAndNumber = temp;
        return true;
    }

    @Override
    public int queryMin() {
        return materialsIdAndNumber.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            }
            return o1.getValue().compareTo(o2.getValue());
        }).findFirst().get().getKey();
    }

    private boolean produce(int productId, HashMap<Integer, Integer> temp) {
        // 下标为物料id
        int[] needMaterials = materialsIdAndNeedNumber.get(productId);
        if (needMaterials == null) {
            System.out.println("------------------------------------");
            System.out.println(productId);
        }
        for (int i = 0; i < needMaterials.length; i++) {
            int needMaterial = needMaterials[i];
            if (needMaterial != 0) {
                Integer num = temp.get(i);
                if (num == null || num == 0) {
                    return false;
                }
                temp.put(i, num - needMaterial);
            }
        }
        return true;
    }
}
