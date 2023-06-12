package org.example.leetcode.probolems.g6;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q661
 * @Description: https://leetcode-cn.com/problems/image-smoother/
 * @author: libo
 * @date: 2021/9/23 0023 22:55
 * @Version: 1.0
 */
@Slf4j
public class Q661 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[][]{
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}},
                imageSmoother(new int[][]{
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}}
                )
        );
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[][]{
                        {137, 141, 137}, {141, 138, 141}, {137, 141, 137}
                },
                imageSmoother(new int[][]{
                        {100, 200, 100}, {200, 50, 200}, {100, 200, 100}
                })
        );
    }

    public int[][] imageSmoother(int[][] img) {
        int row = img.length, col = img[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //[i-1][j-1]  [i-1][j], [i-1][j+1]
                //[i][j-1]     [i][j]   [i][j+1]
                //[i+1][j-1]   [i+1][j] [i+1][j+1]
                int sum = img[i][j], cnt = 1;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    sum += img[i - 1][j - 1];
                    cnt++;
                }
                if (i - 1 >= 0 && j >= 0) {
                    sum += img[i - 1][j];
                    cnt++;
                }
                if (i - 1 >= 0 && j + 1 < col) {
                    sum += img[i - 1][j + 1];
                    cnt++;
                }
                if (i >= 0 && j - 1 >= 0) {
                    sum += img[i][j - 1];
                    cnt++;
                }
                if (i >= 0 && j + 1 < col) {
                    sum += img[i][j + 1];
                    cnt++;
                }
                if (i + 1 < row && j - 1 >= 0) {
                    sum += img[i + 1][j - 1];
                    cnt++;
                }
                if (i + 1 < row && j >= 0) {
                    sum += img[i + 1][j];
                    cnt++;
                }
                if (i + 1 < row && j + 1 < col) {
                    sum += img[i + 1][j + 1];
                    cnt++;
                }

                res[i][j] = sum / cnt;
            }
        }
        return res;
    }
}