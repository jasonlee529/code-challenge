package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Q205
 * @Description: https://leetcode-cn.com/problems/isomorphic-strings/
 * @author: libo
 * @date: 2020/9/18 10:29
 * @Version: 1.0
 */
@Slf4j
public class Q205 {
    public static void main(String[] args) {
        System.out.println(new Q205().isIsomorphic("ab", "aa"));
        System.out.println(new Q205().isIsomorphic("egg2", "add"));
        System.out.println(new Q205().isIsomorphic("foo", "bar"));
    }

    public boolean isIsomorphic(String s, String t) {
        int s1 = 0;
        int s2 = 0;
        boolean is = true;
        Map<Character, Character> chars = new HashMap<>();
        Map<Character, Character> chars2 = new HashMap<>();
        while (s1 < s.length() && s2 < t.length()) {
            char c1 = s.charAt(s1);
            char c2 = t.charAt(s2);
            if (chars.containsKey(c1)) {
                is = is && c2 == chars.get(c1);
            }
            if (chars2.containsKey(c2)) {
                is = is && c1 == chars2.get(c2);
            }
            chars.put(c1, c2);
            chars2.put(c2, c1);
            s1++;
            s2++;
        }
        return is && s1 == s.length() && s2 == t.length();
    }
}
