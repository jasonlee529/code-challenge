package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q326
 * @Description: https://leetcode-cn.com/problems/power-of-three/
 * @author: libo
 * @date: 2020/10/15 16:14
 * @Version: 1.0
 */
@Slf4j
public class Q326 {
    public static void main(String[] args) {
        System.out.println(new Q326().isPowerOfThree(0));
        System.out.println(new Q326().isPowerOfThree(1));
        System.out.println(new Q326().isPowerOfThree(2));
        System.out.println(new Q326().isPowerOfThree(3));
        System.out.println(new Q326().isPowerOfThree(4));
        System.out.println(new Q326().isPowerOfThree(8888));
        System.out.println(new Q326().isPowerOfThree(2147483647));
    }
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        int i = 1;
        while (i>0&& i < n) {
            i = i * 3;
        }
        return i == n;
    }
}
