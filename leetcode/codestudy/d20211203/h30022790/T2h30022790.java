/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20211203.h30022790;

import com.huawei.codestudy.d20211203.base.BaseT2d20211203;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 复制目录
 *
 * @author h30022790
 * @since 2021-12-27
 */
public class T2h30022790 extends BaseT2d20211203 {
    static final String NEWLINE_CHARACTER = "\n";

    /**
     * 合并目录
     *
     * @param targetDirArr 目标目录
     * @param startIndex 目标目录起始位置
     * @param endIndex 目标目录终止位置
     * @param srcDirArr 源目录
     * @return 合并结果
     */
    private static List<String> mergeDir(String[] targetDirArr, int startIndex, int endIndex, String[] srcDirArr) {
        List<String> result = new ArrayList<>();
        int targetIndex = startIndex + 1;  // 目标数组下标从第几个开始
        int srcIndex = 1;  // 源数组下标从第几个开始，不要第一个，它是根结点
        int targetCount = endIndex - startIndex;  // 目标数组范围
        int srcCount = srcDirArr.length - 1;  // 源数组范围
        while (targetIndex - startIndex - 1 < targetCount && srcIndex - 1 < srcCount) {
            String targetFolderName = targetDirArr[targetIndex];
            String srcFolderName = srcDirArr[srcIndex];
            // 为什么可以直接这样比，而不需要判定层级
            // 原因在于空格的ASCII码值比A和a都小，比如"    abc"一定是排在"  ABC"和"  abc"前面的
            if (targetFolderName.compareTo(srcFolderName) < 0) {
                result.add(targetFolderName);
                targetIndex++;
            } else if (targetFolderName.compareTo(srcFolderName) > 0) {
                result.add(srcFolderName);
                srcIndex++;
            } else {  // 目录相同，留一个，删一个
                result.add(srcFolderName);
                srcIndex++;
                // 删一个，就相当于target数组向前走了一步
                targetIndex++;
            }
        }
        // 如果target没完，就把剩下的直接加进去
        while (targetIndex - startIndex - 1 < targetCount) {
            result.add(targetDirArr[targetIndex++]);
        }
        // 如果src没完，就把剩下的直接加进去
        while (srcIndex - 1 < srcCount) {
            result.add(srcDirArr[srcIndex++]);
        }
        return result;
    }

    /**
     * 找出目标数组中的范围，比如给的dstDirLine=3，那么就对应的是usr目录
     *
     * @param targetDirArr 目标数组
     * @param dstDirLine 从第几行开始算范围
     * @return usr目录在targetDirArr数组中的起点和终点下标以及根结点层级，结构为[起点，终点，根结点层级]
     */
    private static int[] getTargetArrayRange(String[] targetDirArr, int dstDirLine) {
        int startIndex = dstDirLine - 1;
        int lastIndex = -1;
        // 找当前目录的终点，比如usr目录，到lib64就结束了，不会再存var
        int rootLevel = getDeepLevel(targetDirArr[startIndex]);
        for (int i = dstDirLine; i < targetDirArr.length; i++) {
            // 当前层级比根层级都小，说明当前目录已经结束，直接跳出即可
            if (getDeepLevel(targetDirArr[i]) <= rootLevel) {
                lastIndex = i - 1;
                break;
            }
        }
        lastIndex = lastIndex == -1 ? targetDirArr.length - 1 : lastIndex;
        return new int[] {startIndex, lastIndex, rootLevel};
    }

    /**
     * 给src数组每个元素前面都拼接空格
     *
     * @param srcDirArr 源数组
     * @param targetRootLevel target数组需要复制的位置是第几层，需要注意的是当前层级是按0 2 4 6 ...这种排列
     */
    private static void enhanceSrcDir(String[] srcDirArr, int targetRootLevel) {
        String space = IntStream.range(0, targetRootLevel).mapToObj(i -> " ").collect(Collectors.joining());
        // 拼接层级空格，以便于直接使用
        IntStream.range(0, srcDirArr.length).forEach(i -> srcDirArr[i] = space + srcDirArr[i]);
    }

    @Override
    public String[] copyDir(String[] targetDir, int dstDirLine, String[] srcDir) {
        int[] targetArrayRange = getTargetArrayRange(targetDir, dstDirLine);
        int startIndex = targetArrayRange[0];
        int endIndex = targetArrayRange[1];
        int rootLevel = targetArrayRange[2];
        enhanceSrcDir(srcDir, rootLevel);
        List<String> result = mergeDir(targetDir, startIndex, endIndex, srcDir);
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(0, startIndex).forEach(i1 -> sb.append(targetDir[i1]).append(NEWLINE_CHARACTER));
        result.forEach(s1 -> sb.append(s1).append(NEWLINE_CHARACTER));
        IntStream.rangeClosed(endIndex + 1, targetDir.length - 1)
            .forEach(i -> sb.append(targetDir[i]).append(NEWLINE_CHARACTER));
        return sb.toString().split(NEWLINE_CHARACTER);
    }

    /**
     * 获取某文件的具体层级，不需要除2，只是用来比大小用
     *
     * @param folderName 文件名
     * @return 层级
     */
    private static int getDeepLevel(String folderName) {
        return folderName.lastIndexOf(' ') + 1;
    }
}
