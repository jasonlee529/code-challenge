package org.example.leetcode.weekly.w206;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q5511
 * @Description: https://leetcode-cn.com/contest/weekly-contest-206/problems/special-positions-in-a-binary-matrix/
 * @author: libo
 * @date: 2020/9/13 11:25
 * @Version: 1.0
 */
@Slf4j
public class Q5511 {
    public static void main(String[] args) {
//        [1,0,0],[0,0,1],[1,0,0]
        System.out.println(new Q5511().numSpecial(new int[][]{new int[]{1, 0, 0}, new int[]{0, 0, 1}, new int[]{1, 0, 0}}));
    }

    public int numSpecial(int[][] mat) {
        int cnt = 0;
        if (mat == null && mat.length == 0) {
            return cnt;
        }
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (mat[i][j] == 1) {
                    if (rows[i] == 0 && cols[j] == 0 && test(mat, i, j, rows.length, cols.length)) {
                        cnt++;
                    }
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(rows));
        System.out.println(Arrays.toString(cols));
        return cnt;
    }

    private boolean test(int[][] mat, int i, int j, int row, int col) {
        boolean isRow = true;
        for (int m = 0; m < col; m++) {
            if (m == j) continue;
            isRow = isRow && mat[i][m] == 0;
        }
        boolean isCol = true;
        for (int m = 0; m < row; m++) {
            if (m == i) continue;
            isCol = isCol && mat[m][j] == 0;
        }
        return isCol && isRow;
    }

}
