package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q367
 * @Description: https://leetcode-cn.com/problems/valid-perfect-square/
 * @author: libo
 * @date: 2020/10/9 23:53
 * @Version: 1.0
 */
@Slf4j
public class Q367 {
    public static void main(String[] args) {
        System.out.println(new Q367().isPerfectSquare(1));
        System.out.println(new Q367().isPerfectSquare(16));
        System.out.println(new Q367().isPerfectSquare(6));
        System.out.println(new Q367().isPerfectSquare(4));
        System.out.println(new Q367().isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
}
