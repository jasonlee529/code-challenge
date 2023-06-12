package org.example.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Q290
 * @Description: https://leetcode-cn.com/problems/word-pattern/
 * @author: libo
 * @date: 2020/9/21 16:52
 * @Version: 1.0
 */
@Slf4j
public class Q290 {
    public static void main(String[] args) {
        System.out.println(new Q290().wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        return convert(pattern.split("")).equals(convert(s.split(" ")));
    }

    private String convert(String[] s) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> pairs = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if(!pairs.containsKey(s[i])){
                pairs.put(s[i],i);
            }
            sb.append(pairs.get(s[i]));
        }
        return sb.toString();
    }

    public boolean wordPattern2(String pattern, String s) {
        Map<String, String> pairs = new HashMap<>();
        String[] ps = pattern.split("");
        String[] ss = s.split(" ");
        for (int i = 0; i < ps.length; i++) {
            String key = ps[i];
            String value = ss[i];
            if (pairs.containsKey(key)) {
                if (!value.equals(pairs.get(key))) {
                    return false;
                }
            } else {
                if (pairs.containsValue(value)) {
                    return false;
                }
                pairs.put(key, value);
            }
        }
        return true;

    }
}
