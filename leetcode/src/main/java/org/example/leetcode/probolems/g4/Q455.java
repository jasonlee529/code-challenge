package org.example.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q455
 * @Description: https://leetcode-cn.com/problems/assign-cookies/
 * @author: libo
 * @date: 2020/9/25 11:40
 * @Version: 1.0
 */
@Slf4j
public class Q455 {
    public int findContentChildren(int[] g, int[] s) {
        int cnt = 0;
        int left = 0, right = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (left < g.length && right < s.length) {
            if (g[left] <= s[right]) {
                cnt++;
                left++;
            }
            right++;
        }
        return cnt;
    }
}
