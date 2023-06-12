package org.example.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q463
 * @Description: https://leetcode-cn.com/problems/island-perimeter/
 * @author: libo
 * @date: 2020/9/25 23:59
 * @Version: 1.0
 */
@Slf4j
public class Q463 {
    public int islandPerimeter(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // up
                    if (i == 0 || grid[i - 1][j] == 0) {
                        cnt++;
                    }
                    //down
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        cnt++;
                    }
                    // left
                    if (j == 0 || grid[i][j - 1] == 0) {
                        cnt++;
                    }
                    //right
                    if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
