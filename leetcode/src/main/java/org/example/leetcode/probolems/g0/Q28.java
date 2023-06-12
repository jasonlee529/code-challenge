package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q28
 * @Description: https://leetcode-cn.com/problems/implement-strstr/
 * @author: libo
 * @date: 2020/9/7 19:49
 * @Version: 1.0
 */
@Slf4j
public class Q28 {
    public static void main(String[] args) {
        System.out.println(new Q28().strStr("hello", "ll"));
        System.out.println(new Q28().strStr("", "ll"));
        System.out.println(new Q28().strStr("a", "a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null
                || needle.equalsIgnoreCase("")) {
            return 0;
        }
        int index = -1;
        int hl = haystack.length();
        int nl = needle.length();
        if (hl < nl) {
            return index;
        }
        for (int i = 0; i <= hl - nl; i++) {
            int j = 0;
            for (; j < nl && haystack.charAt(i + j) == needle.charAt(j); j++) {

            }
            if (j == nl) {
                index = i;
                break;
            }

        }
        return index;
    }
}
