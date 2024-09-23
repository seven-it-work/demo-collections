package com.huawei.codestudy.d20220226.y00375357;

import com.huawei.codestudy.d20220226.Main2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CustomFile extends Main2 {
    @Override
    public int delDirectorys(String delDirNameBunch, String[] dirTreeLines) {
        if (delDirNameBunch == null || delDirNameBunch.length() < 1) {
            return 0;
        }

        String[] delDirArray = delDirNameBunch.split(" ");
        if (delDirArray.length == 0) {
            return dirTreeLines.length;
        }

        List<String> fileDir = Arrays.asList(delDirArray);
        boolean isHandled = false;
        do {
            for (String delDir : delDirArray) {
                isHandled = isHandled || deleteDir(fileDir, delDir);
            }
        } while (isHandled);

        return fileDir.size();
    }

    private boolean deleteDir(List<String> fileDir, String delDir) {
        boolean isHandled = false;
        boolean isDeleted;
        do {
            isDeleted = false;
            Iterator<String> iterator = fileDir.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().endsWith(delDir)) {
                    iterator.remove();
                    isDeleted = true;
                    isHandled = true;
                }
            }
        } while (isDeleted);
        return isHandled;
    }
}
