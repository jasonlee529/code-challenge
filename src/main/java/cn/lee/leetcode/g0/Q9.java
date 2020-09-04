package cn.lee.leetcode.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q9
 * @Description: https://leetcode-cn.com/problems/palindrome-number/
 * @author: libo
 * @date: 2020/9/4 13:54
 * @Version: 1.0
 */
@Slf4j
public class Q9 {
    public static void main(String[] args) {
        Q9 q = new Q9();
        System.out.println(q.isPalindrome(-121));
        System.out.println(q.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rev = 0;
        int y = x;
        while (x != 0) {
            int m = x % 10;
            x = x / 10;
            rev = rev * 10 + m;
        }
        System.out.println(rev);
        return rev == y;
    }
}
