package com.huawei.codestudy.d20211217.y00375357;

import java.util.ArrayList;
import java.util.List;

public class DeviceConnect extends com.huawei.codestudy.d20211217.T2 {
    @Override
    public int[] checkConnectivity(int num, int[][] operations) {
        int[] result = new int[num];
        List<List<Integer>> initDeviceStatus = getInitDeviceStatus(num);
        for (int i = 0; i < operations.length; i++) {
            result[i] = doOperationAndCheck(initDeviceStatus, operations[i], num);
        }

        return result;
    }

    private List<List<Integer>> getInitDeviceStatus(int num) {
        List<List<Integer>> deviceStatus = new ArrayList<>();
        List<Integer> subDeviceStatus = null;
        for (int i = 0; i < 2; i++) {
            subDeviceStatus = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                subDeviceStatus.add(1);
            }
            deviceStatus.add(subDeviceStatus);
        }

        return deviceStatus;
    }

    private int doOperationAndCheck(List<List<Integer>> initDeviceStatus, int[] operations, int num) {
        if (initDeviceStatus.get(operations[0]).get(operations[1] - 1) == 0) {
            initDeviceStatus.get(operations[0]).set(operations[1] - 1, 1);
        } else {
            initDeviceStatus.get(operations[0]).set(operations[1] - 1, 0);
        }

        return checkDeviceConnect(initDeviceStatus, num);
    }

    private int checkDeviceConnect(List<List<Integer>> initDeviceStatus, int num) {
        for (int i = 0; i < num - 1; i++) {
            if ((initDeviceStatus.get(0).get(i) == 0 || initDeviceStatus.get(0).get(i + 1) == 0) &&
                (initDeviceStatus.get(1).get(i) == 0 || initDeviceStatus.get(1).get(i + 1) == 0)) {
                return 0;
            }
        }

        return 1;
    }
}
