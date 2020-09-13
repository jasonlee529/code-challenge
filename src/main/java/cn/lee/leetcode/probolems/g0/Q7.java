package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q7
 * @Description: https://leetcode-cn.com/problems/reverse-integer/
 * @author: libo
 * @date: 2020/9/3 22:16
 * @Version: 1.0
 */
@Slf4j
public class Q7 {
    public static void main(String[] args) {
        Q7 q7 = new Q7();
        System.out.println(q7.reverse(-100));
        System.out.println(q7.reverse2(123));
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse2(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sb.append(s.charAt(0));
            for (int i = s.length() - 1; i >= 1; i--) {
                sb.append(s.charAt(i));
            }
        } else {
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
        }
        if (String.valueOf(Integer.MIN_VALUE).compareTo(sb.toString()) <= 0 &&
                String.valueOf(Integer.MAX_VALUE).compareTo(sb.toString()) >= 0) {
            return Integer.valueOf(sb.toString());
        }
        return 0;
    }
}
