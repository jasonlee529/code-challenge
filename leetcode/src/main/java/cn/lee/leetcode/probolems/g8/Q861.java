package cn.lee.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q861
 * @Description: https://leetcode-cn.com/problems/score-after-flipping-matrix/
 * @author: libo
 * @date: 2020/12/7 11:20
 * @Version: 1.0
 */
@Slf4j
public class Q861 {

    @Test
    public void test() {
        Assert.assertEquals(39, matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }

    public int matrixScore(int[][] A) {
        //翻转行
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                continue;
            } else {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = A[i][j] ^ 1;
                }
            }
        }
        //翻转列
        for (int j = 1; j < A[0].length; j++) {
            int cnt = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 1) {
                    cnt++;
                }
            }
            if (cnt * 2 < A.length) {
                for (int i = 0; i < A.length; i++) {
                    A[i][j] = A[i][j] ^ 1;
                }
            }
        }
        //计算求和
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int tmp = 0;
            for (int j = 0; j < A[i].length; j++) {
                tmp = tmp * 2 + A[i][j];
            }
            sum += tmp;
        }
        return sum;
    }
}
