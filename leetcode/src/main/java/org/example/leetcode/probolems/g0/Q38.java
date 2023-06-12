package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q38
 * @Description: https://leetcode-cn.com/problems/count-and-say/
 * @author: libo
 * @date: 2020/9/16 11:07
 * @Version: 1.0
 */
@Slf4j
public class Q38 {
    public static void main(String[] args) {
        System.out.println(new Q38().countAndSay(1));
        System.out.println(new Q38().countAndSay(2));
        System.out.println(new Q38().countAndSay(3));
        System.out.println(new Q38().countAndSay(4));
        System.out.println(new Q38().countAndSay(5));
        System.out.println(new Q38().countAndSay(6));
    }

    /**
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                cnt++;
                sb.append(cnt).append(s.charAt(i));
            } else if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
                continue;
            } else {
                sb.append(cnt+1).append(s.charAt(i));
                cnt=0;
            }
        }
        return sb.toString();
    }
}
