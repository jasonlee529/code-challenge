package org.example.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title: Q387
 * @Description: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @author: libo
 * @date: 2020/9/11 17:53
 * @Version: 1.0
 */
@Slf4j
public class Q387 {
    public static void main(String[] args) {
        System.out.println(new Q387().firstUniqChar("cc"));
        System.out.println(new Q387().firstUniqChar("ccc"));
        System.out.println(new Q387().firstUniqChar("leetcode"));
        System.out.println(new Q387().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        LinkedHashMap<Character, Integer> pos = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (pos.containsKey(s.charAt(i))) {
                pos.put(s.charAt(i), pos.get(s.charAt(i)) + 1);
            } else {
                pos.put(s.charAt(i), 1);
            }
        }
        Character c = null;
        for (Map.Entry<Character, Integer> kv : pos.entrySet()) {
            if (kv.getValue() == 1) {
                c = kv.getKey();
                break;
            }
        }
        return c == null ? -1 : s.indexOf(c);
    }

    public int firstUniqChar2(String s) {
        if (s.length() == 1) {
            return 0;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right = s.length() - 1;
            } else {
                right--;
            }
        }
        return left >= s.length() || right == s.length() - 1 ? -1 : left;
    }
}
