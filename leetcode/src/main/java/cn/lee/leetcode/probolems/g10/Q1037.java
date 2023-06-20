package cn.lee.leetcode.probolems.g10;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q1037
 * @Description: https://leetcode-cn.com/problems/valid-boomerang/
 * @author: libo
 * @date: 2020/9/23 22:51
 * @Version: 1.0
 */
@Slf4j
public class Q1037 {
    public boolean isBoomerang(int[][] points) {
        boolean is = true;
        int x0 = (points[1][0] - points[0][0]);
        int x1 = (points[2][0] - points[1][0]);
        int y0 = (points[1][1] - points[0][1]);
        int y1 = (points[2][1] - points[1][1]);
        return !(y1 * x0 == y0 * x1);
    }
}
