package com.huawei.codestudy.d20220226.y00375357;

import com.huawei.codestudy.d20220226.Main1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckSum extends Main1 {
    @Override
    public String simpleCheckSum(String inputStr) {
        if (inputStr == null || inputStr.length() < 2 || inputStr.length() > 200) {
            return null;
        }

        String[] checkStrArray = inputStr.split(" ");
        List<String> checkStrList = getCheckStrList(checkStrArray);
        if (checkStrList.size() == 4) {
            return String.join("", checkStrList);
        }

        List<String> initCheckSum = checkStrList.subList(0, 3);
        for (int i = 1; i < checkStrList.size() / 4; i++) {
            initCheckSum = getXorString(initCheckSum, checkStrList.subList(i * 4, i * 4 + 3));
        }

        return String.join("", initCheckSum);
    }

    private List<String> getCheckStrList(String[] checkStrArray) {
        List<String> checkStrList = Arrays.asList(checkStrArray);
        if (checkStrList.size() % 4 != 0) {
            for (int i = 0; i < 4 - checkStrList.size() % 4; i++) {
                checkStrList.add("FF");
            }
        }

        return checkStrList;
    }

    private List<String> getXorString(List<String> src, List<String> desc) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < src.size(); i++) {
            result.add(getXorString(src.get(i), desc.get(i)));
        }
        return result;
    }

    private String getXorString(String src, String desc) {
        int srcInt = Integer.parseInt(src, 16);
        int descInt = Integer.parseInt(desc, 16);
        int result = srcInt ^ descInt;
        String resultStr = "  " + result;
        return resultStr.substring(resultStr.length() - 2);
    }
}
