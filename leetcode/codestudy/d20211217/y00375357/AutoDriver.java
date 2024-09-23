package com.huawei.codestudy.d20211217.y00375357;

import com.huawei.codestudy.d20211217.T3;

public class AutoDriver extends T3 {
    public int getMinCollectionTime(int[][] cars) {
        if(cars.length <= 1){
            return 0;
        }

        if(cars.length == 2){
            return Math.abs(cars[0][0] - cars[1][0]) / Math.abs(cars[0][1] + cars[1][1]);
        }

        int time = 1;
        int[] meetRange;
        boolean isMeet;

        while (true) {
            isMeet = true;
            meetRange = getTimeRange(cars[0], time);
            if (meetRange[0] > meetRange[1]) {
                return -1;
            }

            for (int i = 1; i < cars.length; i++) {
                meetRange = checkRange(getTimeRange(cars[i], time), meetRange);
                if (meetRange[0] > meetRange[1]) {
                    time++;
                    isMeet = false;
                    break;
                }
            }

            if (isMeet) {
                return time;
            }
        }
    }

    private int[] getTimeRange(int[] car, int time) {
        int[] meetRange = new int[2];
        meetRange[0] = Math.max(car[0] - time * car[1], Integer.MIN_VALUE);
        meetRange[1] = Math.min(car[0] + time * car[1], Integer.MAX_VALUE);
        return meetRange;
    }

    private int[] checkRange(int[] car, int[] meetRange) {
        int[] nextMeetRange = new int[2];
        nextMeetRange[0] = Math.max(car[0], meetRange[0]);
        nextMeetRange[1] = Math.min(car[1], meetRange[1]);
        return nextMeetRange;
    }
}
