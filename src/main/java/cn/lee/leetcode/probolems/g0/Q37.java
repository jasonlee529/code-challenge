package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title: Q37
 * @Description: https://leetcode-cn.com/problems/sudoku-solver/
 * @author: libo
 * @date: 2020/9/15 10:04
 * @Version: 1.0
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
@Slf4j
public class Q37 {
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        dfs(board, rows, cols, 0, 0);
    }

    private void dfs(char[][] board, int[] rows, int[] cols, int i, int j) {
        if (i == 9) {
            return;
        }
        if (j == 9) {
            i++;
            j = 0;
        }
        if (board[i][j] == '.') {
            int[] arr = find(rows, cols);
        }

    }

    private int[] find(int[] rows, int[] cols) {
        Set<Integer> set = new HashSet<>();
        for (int i : rows) {
            if (i == 0) {
                set.add(i);
            }
        }
        return new int[0];
    }
}
