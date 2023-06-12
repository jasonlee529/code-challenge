package org.example.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Q383
 * @Description: https://leetcode-cn.com/problems/ransom-note/
 * @author: libo
 * @date: 2020/9/11 17:26
 * @Version: 1.0
 */
@Slf4j
public class Q383 {
    public static void main(String[] args) {
        System.out.println(new Q383().canConstruct("aa","ab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> src = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (src.containsKey(c)) {
                src.put(c, src.get(c) + 1);
            } else {
                src.put(c, 1);
            }
        }
        for (char c : magazine.toCharArray()) {
            if (src.containsKey(c)) {
                Integer value = src.get(c);
                if (value == 1) {
                    src.remove(c);
                } else {
                    src.put(c, value - 1);
                }
            }
        }
        return src.isEmpty();
    }
}
