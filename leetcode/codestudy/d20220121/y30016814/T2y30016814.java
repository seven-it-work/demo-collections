/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220121.y30016814;

import com.huawei.codestudy.d20220121.T2;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author y30016814
 * @since 2022/1/29 14:11
 */
public class T2y30016814 extends T2 {
    Storage coldStorage;
    Storage normalStorage;

    @Override
    public void storageSystem(int coldStorageNum, int coldStoragePrice, int normalStorageNum, int normalStoragePrice,
        int delay) {
        coldStorage = new Storage(coldStorageNum, coldStoragePrice, delay);
        normalStorage = new Storage(normalStorageNum, normalStoragePrice, delay);
    }

    @Override
    public int store(int date, int storageId, int storageType, int storageDays) {
        Goods goods = new Goods(storageId, date, storageDays);
        if (storageType == 1) {
            // 常温
            normalStorage.clean(date);
            int saveResult = normalStorage.save(goods);
            if (saveResult != -1) {
                return saveResult;
            }
            // 常温不够继续冷藏
        }
        // 冷藏
        coldStorage.clean(date);
        return coldStorage.save(goods);
    }

    @Override
    public int retrieve(int date, int storageId) {
        Goods goods = coldStorage.take(date, storageId);
        if (goods != null) {
            int expirationTime = date - goods.startDate - goods.saveDays;
            if (expirationTime > 0) {
                return expirationTime * coldStorage.price;
            } else {
                return 0;
            }
        }
        goods = normalStorage.take(date, storageId);
        if (goods != null) {
            int expirationTime = date - goods.startDate - goods.saveDays;

            if (expirationTime > 0) {
                return expirationTime * normalStorage.price;
            } else {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public int[] query(int date) {
        int[] coldQuery = coldStorage.query(date);
        int[] normalQuery = normalStorage.query(date);
        return new int[] {coldQuery[0] + normalQuery[0], coldQuery[1] + normalQuery[1], coldQuery[2] + normalQuery[2]};
    }

    static class Storage {
        private final int storageNum;
        private final int price;
        private final int delay;
        private final HashMap<Integer, Goods> goodsHashMap;
        private final int[] status = new int[3];

        public Storage(int storageNum, int price, int delay) {
            this.storageNum = storageNum;
            this.price = price;
            this.delay = delay;
            this.goodsHashMap = new HashMap<>();
        }

        private int save(Goods goods) {
            if (goodsHashMap.containsKey(goods.goodsId)) {
                // 存储了, 目前逻辑不覆盖，返回以前的预支付费用
                return goodsHashMap.get(goods.goodsId).saveDays * price;
            } else if (goodsHashMap.size() < storageNum) {
                goodsHashMap.put(goods.goodsId, goods);
                status[1]++;
                return goods.saveDays * price;
            } else {
                // 存储空间不够
                return -1;
            }
        }

        private Goods take(int date, int goodsId) {
            Goods remove = goodsHashMap.remove(goodsId);
            if (remove == null) {
                return null;
            } else {
                // 计算是否到期
                if (remove.isExpired(date, delay)) {
                    status[2]++;
                    status[1]--;
                    return null;
                } else {
                    status[0]++;
                    status[1]--;
                    return remove;
                }
            }
        }

        private int[] query(int date) {
            this.clean(date);
            return status;
        }

        private void clean(int date) {
            List<Goods> collect = goodsHashMap.values()
                .stream()
                .filter(goods -> goods.isExpired(date, delay)).collect(Collectors.toList());
            status[2] += collect.size();
            status[1] -= collect.size();
            collect
                .forEach(goods -> goodsHashMap.remove(goods.goodsId));
        }
    }

    static class Goods {
        private final int goodsId;
        private final int startDate;
        private final int saveDays;

        public Goods(int goodsId, int startDate, int saveDays) {
            this.goodsId = goodsId;
            this.startDate = startDate;
            this.saveDays = saveDays;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Goods goods = (Goods) o;
            return goodsId == goods.goodsId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(goodsId);
        }

        private boolean isExpired(int date, int delay) {
            return startDate + saveDays + delay < date;
        }
    }
}
