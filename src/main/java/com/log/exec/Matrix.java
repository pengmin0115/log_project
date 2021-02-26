package com.log.exec;

/**
 * @author pengmin
 * @date 2021/2/25 14:48
 */

public class Matrix {

    /**
     * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
     * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[1,4,7],[2,5,8],[3,6,9]]
     *
     * 输入：matrix = [[1,2,3],[4,5,6]]
     * 输出：[[1,4],[2,5],[3,6]]
     */

    public int[][] transpose(int[][] srcMatrix){
        int row = srcMatrix.length;
        int column = srcMatrix[0].length;
        int[][] resMatrix = new int[column][row];
        for (int i = 0; i < srcMatrix.length; i++) {
            for (int j = 0; j < srcMatrix[i].length; j++) {
                resMatrix[j][i] = srcMatrix[i][j];
            }
        }
        return resMatrix;
    }

}
