package com.huawei.codestudy.d20220121.y00375357;

import com.huawei.codestudy.d20220121.T1;

public class Wall extends T1 {
    @Override
    public int getPaintedLineNum(int rows, int cols, int[][] lines, int[][] positions) {
        int[][] allPoints = new int[rows][cols];
        for (int[] position : positions) {
            allPoints[position[0]][position[1]] = 1;
        }

        int coverageLineCount = 0;
        for (int[] line : lines) {
            if (isCoverage(allPoints, line)) {
                coverageLineCount++;
            }
        }

        return coverageLineCount;
    }

    private boolean isCoverage(int[][] allPoints, int[] line) {
        int beginRow = Math.min(line[0], line[2]);
        int beginCol = Math.min(line[1], line[3]);
        int deltaRow = Math.abs(line[0] - line[2]);
        int deltaCol = Math.abs(line[1] - line[3]);

        if (deltaRow == 0) {
            return handleX(allPoints, beginRow, beginCol, deltaCol);
        }

        if (deltaCol == 0) {
            return handleY(allPoints, beginRow, beginCol, deltaRow);
        }

        if (deltaCol != deltaRow) {
            return false;
        }

        return handleXY(allPoints, line, deltaRow);
    }

    private boolean handleX(int[][] allPoints, int beginRow, int beginCol, int deltaCol){
        for (int i = 0; i <= deltaCol; i++) {
            if (allPoints[beginRow][beginCol + i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean handleY(int[][] allPoints, int beginRow, int beginCol, int deltaRow){
        for (int i = 0; i <= deltaRow; i++) {
            if (allPoints[beginRow + i][beginCol] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean handleXY(int[][] allPoints, int[] line, int deltaRow){
        for (int i = 0; i <= deltaRow; i++) {
            if (line[0] < line[2]){
                if(!handleXYAsc(allPoints, line, i)){
                    return false;
                }
            }else{
                if(!handleXYDesc(allPoints, line, i)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean handleXYAsc(int[][] allPoints, int[] line, int i){
        if(line[1] < line[3]){
            if (allPoints[line[0] + i][line[1] + i] == 0) {
                return false;
            }
        }
        else{
            if (allPoints[line[0] + i][line[1] - i] == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean handleXYDesc(int[][] allPoints, int[] line, int i){
        if(line[1] < line[3]){
            if (allPoints[line[0] - i][line[1] + i] == 0) {
                return false;
            }
        }
        else{
            if (allPoints[line[0] - i][line[1] - i] == 0) {
                return false;
            }
        }

        return true;
    }
}
