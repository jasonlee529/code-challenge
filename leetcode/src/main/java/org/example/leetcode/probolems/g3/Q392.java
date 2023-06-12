package org.example.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q392
 * @Description: https://leetcode-cn.com/problems/is-subsequence/
 * @author: libo
 * @date: 2020/9/30 15:38
 * @Version: 1.0
 */
@Slf4j
public class Q392 {
    public static void main(String[] args) {
        System.out.println(new Q392().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Q392().isSubsequence("aaaaaa", "bbaaaa"));
    }

    public boolean isSubsequence(String s, String t) {
        int p = 0;
        boolean is = true;
        for (char c : s.toCharArray()) {
            int p0 = t.indexOf(c, p);
            if (p0 == -1) {
                is = false;
                break;
            } else {
                p = p0 + 1;
            }
        }
        return is;
    }
}
