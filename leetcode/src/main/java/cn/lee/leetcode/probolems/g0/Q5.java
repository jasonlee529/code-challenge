package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @author libo
 * @Title: Q5
 * @Description: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @date 2020/9/1 15:08
 * @Version 1.0
 */
@Slf4j
public class Q5 {
    public static void main(String[] args) {
        Q5 q = new Q5();
        System.out.println(q.longestPalindrome("aa"));
        System.out.println(q.longestPalindrome("abba"));
        System.out.println(q.longestPalindrome("abbac"));
    }

    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {//边界s[i]==s[j]的时候，如果j-i ==3 或2  或1 都是回文串
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
                System.out.println(String.format("%d,%d,%b", i, j, dp[i][j]));
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome3(String s) {
        LinkedList<Character> asc = new LinkedList<>();
        LinkedList<Character> desc = new LinkedList<>();
        for (char c : s.toCharArray()) {
            asc.add(c);
            desc.push(c);
        }
        boolean is = true;
        String res = "";
        StringBuilder sb = new StringBuilder();
        while (asc.size() > 0) {
            char c = asc.poll();
            if (c == desc.poll()) {
                sb.append(c);
            } else {
                is = false;
                if (res.length() < sb.toString().length()) {
                    res = sb.toString();
                }
                sb = new StringBuilder();
            }
        }
        if (is) {
            res = sb.toString();
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        int max = 0;
        String t = "";
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (n - i < max) {
                break;
            }
            for (int j = s.length() - 1; j >= i; j--) {
                if (j - i < max) {
                    break;
                }
                if (isPalindrome(s.substring(i, j + 1))) {
                    max = j - i;
                    t = s.substring(i, j + 1);
                }
            }
        }
        return t;
    }

    private boolean isPalindrome(String substring) {
        LinkedList<Character> asc = new LinkedList<>();
        LinkedList<Character> desc = new LinkedList<>();
        for (char c : substring.toCharArray()) {
            asc.add(c);
            desc.push(c);
        }
        boolean is = true;
        while (is && asc.size() > 0) {
            is = asc.poll() == desc.poll();
        }
        return is;
    }
}
