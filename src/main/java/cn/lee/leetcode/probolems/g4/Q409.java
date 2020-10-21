package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q409
 * @Description: https://leetcode-cn.com/problems/longest-palindrome/
 * @author: libo
 * @date: 2020/10/21 13:41
 * @Version: 1.0
 */
@Slf4j
public class Q409 {
    public static void main(String[] args) {
        System.out.println(new Q409().longestPalindrome("abccccdd"));
        System.out.println(new Q409().longestPalindrome("ccc"));
    }

    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c] = arr[c] + 1;
        }
        int cnt = 0;
        int d = 0;
        for (int n : arr) {
            if (n % 2 == 0) {
                cnt += n;
            }
            if (n % 2 == 1 && d == 0) {
                d = 1;
                cnt += n;
            } else if (n % 2 == 1 && d != 0) {
                cnt += n - 1;
            }
        }
        return cnt;
    }
}
