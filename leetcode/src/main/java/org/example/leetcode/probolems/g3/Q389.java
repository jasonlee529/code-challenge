package org.example.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q389
 * @Description: https://leetcode-cn.com/problems/find-the-difference/
 * @author: libo
 * @date: 2020/9/30 15:22
 * @Version: 1.0
 */
@Slf4j
public class Q389 {
    public static void main(String[] args) {
        System.out.println(new Q389().findTheDifference("abcd", "abecd"));
    }

    public char findTheDifference(String s, String t) {
        for (char c : s.toCharArray()) {
            t = t.replaceFirst(String.valueOf(c), "");
        }
        return t.charAt(0);
    }
}
