/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220121.h30022790;

import com.huawei.codestudy.d20220121.T2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-22
 */
public class T2StorageSystem extends T2 {

    private List<Customer> coldBoxes;

    private int coldStorageNum;

    private int coldStoragePrice;

    private List<Customer> normalBoxes;

    private int normalStorageNum;

    private int normalStoragePrice;

    private int delay;

    private int[] statusNums;

    @Override
    public void storageSystem(int coldStorageNum, int coldStoragePrice, int normalStorageNum, int normalStoragePrice,
        int delay) {
        this.coldBoxes = new LinkedList<>();
        this.normalBoxes = new LinkedList<>();
        this.coldStorageNum = coldStorageNum;
        this.coldStoragePrice = coldStoragePrice;
        this.normalStorageNum = normalStorageNum;
        this.normalStoragePrice = normalStoragePrice;
        this.delay = delay;
        this.statusNums = new int[3];
    }

    @Override
    public int store(int date, int storageId, int storageType, int storageDays) {
        removeCold(date);
        removeNormal(date);

        Customer customer = new Customer();
        customer.setDate(date);
        customer.setStorageId(storageId);
        customer.setStorageDays(storageDays);
        if (storageType == 1) {
            // 常温不够
            return innerStore(this.normalStorageNum <= 0 ? 0 : storageType, customer);
        } else {
            return innerStore(storageType, customer);
        }
    }

    @Override
    public int retrieve(int date, int storageId) {
        Customer last = coldBoxes.stream()
            .filter(customer -> customer.getStorageId() == storageId)
            .findFirst()
            .orElse(normalBoxes.stream()
                .filter(customer -> customer.getStorageId() == storageId)
                .findFirst()
                .orElse(null));
        if (last == null) {
            return -1;
        }
        if (date > last.getDate() + last.getStorageDays() + this.delay) {  // 超期
            if (last.getStorageType() == 1) {
                normalBoxes.remove(last);
                this.normalStorageNum++;
            } else {
                this.coldStorageNum++;
                coldBoxes.remove(last);
            }
            statusNums[2]++;
            return -1;
        } else if (date <= last.getDate() + last.getStorageDays()) {  // 未到期
            if (last.getStorageType() == 1) {
                this.normalStorageNum++;
                normalBoxes.remove(last);
            } else {
                this.coldStorageNum++;
                coldBoxes.remove(last);
            }
            this.statusNums[0]++;
            return 0;
        } else {  // 到期还没超期
            int need = date - (last.getDate() + last.getStorageDays());
            this.statusNums[0]++;
            if (last.getStorageType() == 1) {
                this.normalStorageNum++;
                normalBoxes.remove(last);
                return need * this.normalStoragePrice;
            } else {
                this.coldStorageNum++;
                coldBoxes.remove(last);
                return need * this.coldStoragePrice;
            }
        }
    }

    @Override
    public int[] query(int date) {
        removeCold(date);
        removeNormal(date);
        statusNums[1] = coldBoxes.size() + normalBoxes.size();
        return Arrays.copyOf(statusNums, 3);
    }

    /**
     * 存放物品与客户关系对应类
     */
    static class Customer {
        private int storageId;

        private int date;

        private int storageType;

        private int storageDays;

        public int getStorageId() {
            return storageId;
        }

        public void setStorageId(int storageId) {
            this.storageId = storageId;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getStorageType() {
            return storageType;
        }

        public void setStorageType(int storageType) {
            this.storageType = storageType;
        }

        public int getStorageDays() {
            return storageDays;
        }

        public void setStorageDays(int storageDays) {
            this.storageDays = storageDays;
        }

        public int getPrice(int dayFee) {
            return storageDays * dayFee;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Customer customer = (Customer) o;
            return storageId == customer.storageId && storageType == customer.storageType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(storageId, storageType);
        }
    }


    private void removeNormal(int date) {
        Iterator<Customer> iterator = this.normalBoxes.iterator();
        while (iterator.hasNext()) {
            Customer last = iterator.next();
            if (date > last.getDate() + last.getStorageDays() + this.delay) {  // 超期
                iterator.remove();
                this.normalStorageNum++;
                statusNums[2]++;
            }
        }
    }

    private void removeCold(int date) {
        Iterator<Customer> iterator = this.coldBoxes.iterator();
        while (iterator.hasNext()) {
            Customer last = iterator.next();
            if (date > last.getDate() + last.getStorageDays() + this.delay) {  // 超期
                iterator.remove();
                this.coldStorageNum++;
                statusNums[2]++;
            }
        }
    }

    private int innerStore(int storageType, Customer customer) {
        customer.setStorageType(storageType);
        if (storageType == 1) {
            if (this.normalStorageNum > 0) {
                normalBoxes.add(customer);
                this.normalStorageNum--;
            } else {
                return -1;
            }
        } else {
            if (this.coldStorageNum > 0) {
                coldBoxes.add(customer);
                this.coldStorageNum--;
            } else {
                return -1;
            }
        }
        return customer.getPrice(storageType == 1 ? normalStoragePrice : coldStoragePrice);
    }
}
