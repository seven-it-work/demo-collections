package com.huawei.codestudy.d20220226.y00375357;

import com.huawei.codestudy.d20220226.Main3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MutexProcess extends Main3 {
    @Override
    public int calcRunTime(int[][] mutexs, int[] appRunTimes) {
        int sum = 0;
        if (mutexs.length == 0) {
            for (int i = 0; i < appRunTimes.length; i++) {
                sum += appRunTimes[i];
            }
            return sum;
        }

        List<Integer> secPro = new ArrayList<>();
        Map<Integer, List<Integer>> unSecPro = new HashMap<>();

        for (int i = 0; i < mutexs.length; i++) {
            for(int j = 0; j < mutexs[i].length; j++){
                if(unSecPro.containsKey(mutexs[i][j])){

                }
            }

        }

        return 0;

    }
}
