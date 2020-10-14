package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q242
 * @Description: https://leetcode-cn.com/problems/valid-anagram/
 * @author: libo
 * @date: 2020/10/14 13:42
 * @Version: 1.0
 */
@Slf4j
public class Q242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        return Arrays.equals(ss, ts);
    }
}
