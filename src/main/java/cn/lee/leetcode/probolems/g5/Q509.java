package cn.lee.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q509
 * @Description: https://leetcode-cn.com/problems/fibonacci-number/
 * @author: libo
 * @date: 2020/9/28 14:47
 * @Version: 1.0
 */
@Slf4j
public class Q509 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Q509().fib(i));
        }
    }

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }
}
