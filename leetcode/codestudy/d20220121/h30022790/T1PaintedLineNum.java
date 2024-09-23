/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220121.h30022790;

import com.huawei.codestudy.d20220121.T1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-22
 */
public class T1PaintedLineNum extends T1 {
    @Override
    public int getPaintedLineNum(int rows, int cols, int[][] lines, int[][] positions) {
        if (lines == null || lines.length == 0) {
            return 0;
        }
        if (positions == null || positions.length == 0) {
            return 0;
        }
        boolean[][] points = new boolean[rows][cols];
        Arrays.stream(positions).forEach(position -> points[position[0]][position[1]] = true);
        return (int) Arrays.stream(lines)
            .filter(line -> isCover(points, constructPoints(line[0], line[1], line[2], line[3])))
            .count();
    }

    private boolean isCover(boolean[][] points, List<int[]> linePoints) {
        return linePoints.stream().allMatch(linePoint -> points[linePoint[0]][linePoint[1]]);
    }

    public List<int[]> constructPoints(int sRow, int sCol, int eRow, int eCol) {
        int colSign = (eCol - sCol) > 0 ? 1 : -1;
        int rowSign = (eRow - sRow) > 0 ? 1 : -1;
        if (sCol == eCol) {
            return IntStream.rangeClosed(0, Math.abs(eRow - sRow))
                .mapToObj(i -> new int[] {sRow + rowSign * i, sCol})
                .collect(Collectors.toList());
        }
        if (sRow == eRow) {
            return IntStream.rangeClosed(0, Math.abs(eCol - sCol))
                .mapToObj(i -> new int[] {sRow, sCol + colSign * i})
                .collect(Collectors.toList());
        }
        if (sRow <= eRow && sCol <= eCol || sRow >= eRow && sCol >= eCol) {
            return IntStream.rangeClosed(0, Math.abs(sCol - eCol))
                .mapToObj(i -> new int[] {sRow + colSign * i, sCol + colSign * i})
                .collect(Collectors.toList());
        }
        return IntStream.rangeClosed(0, Math.abs(sCol - eCol))
            .mapToObj(i -> new int[] {sRow - colSign * i, sCol + colSign * i})
            .collect(Collectors.toList());
    }
}
