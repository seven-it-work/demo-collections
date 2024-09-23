package com.huawei.codestudy.d20220121.y00375357;

import com.huawei.codestudy.d20220121.T2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoreSystem extends T2 {
    private int coldStorageNum;
    private int coldStoragePrice;
    private int normalStorageNum;
    private int normalStoragePrice;
    private int delay;
    private final Map<Integer, Order> currentNormal = new HashMap<>();
    private final Map<Integer, Order> currentCold = new HashMap<>();
    private final static int STORAGE_SYSTEM_TYPE_COLD = 0;
    private final static int STORAGE_SYSTEM_TYPE_NORMAL = 1;

    @Override
    public void storageSystem(int coldStorageNum, int coldStoragePrice, int normalStorageNum, int normalStoragePrice,
        int delay) {
        this.coldStorageNum = coldStorageNum;
        this.coldStoragePrice = coldStoragePrice;
        this.normalStorageNum = normalStorageNum;
        this.normalStoragePrice = normalStoragePrice;
        this.delay = delay;

    }

    @Override
    public int store(int date, int storageId, int storageType, int storageDays) {
        if (storageType == STORAGE_SYSTEM_TYPE_COLD) {
            if (currentCold.size() < this.coldStorageNum) {
                return storeCold(storageId, storageType, storageDays, date);
            }
        } else if (storageType == STORAGE_SYSTEM_TYPE_NORMAL) {
            if (currentNormal.size() < this.normalStorageNum) {
                return storeNormal(storageId, storageType, storageDays, date);
            } else if (currentCold.size() < this.coldStorageNum) {
                return storeCold(storageId, storageType, storageDays, date);
            }
        }

        return -1;
    }

    private int storeNormal(int date, int storageId, int storageType, int storageDays) {
        Order order = new Order(storageId, storageType, storageDays, date);
        currentNormal.put(storageId, order);
        return normalStoragePrice * storageDays;
    }

    private int storeCold(int date, int storageId, int storageType, int storageDays) {
        Order order = new Order(storageId, storageType, storageDays, date);
        currentCold.put(storageId, order);
        return coldStoragePrice * storageDays;
    }

    @Override
    public int retrieve(int date, int storageId) {
        Order order = getOrderFromSystem(storageId);

        if (order == null) {
            return -1;
        }

        currentCold.remove(storageId);
        currentNormal.remove(storageId);

        return getRetrievePrice(order, date);
    }

    private Order getOrderFromSystem(int storageId) {
        Order order = currentNormal.get(storageId);
        return order == null ? currentCold.get(storageId) : order;
    }

    private int getRetrievePrice(Order order, int date) {
        if (date - order.getDate() <= order.getStorageDays()) {
            return 0;
        } else if (date - order.getDate() <= delay) {
            int overDay = date - order.getDate() - order.getStorageDays();
            return order.storageType == STORAGE_SYSTEM_TYPE_COLD
                ? overDay * coldStoragePrice
                : overDay * normalStoragePrice;
        } else {
            return -1;
        }
    }

    @Override
    public int[] query(int date) {
        return new int[0];
    }

    static class Order {
        private final int storageId;
        private final int storageType;
        private final int storageDays;
        private final int date;

        public Order(int storageId, int storageType, int storageDays, int date) {
            this.storageId = storageId;
            this.storageType = storageType;
            this.storageDays = storageDays;
            this.date = date;
        }

        public int getStorageDays() {
            return storageDays;
        }

        public int getDate() {
            return date;
        }

    }
}
