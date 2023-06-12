package org.example.leetcode.probolems.g10;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Q1002
 * @Description: https://leetcode-cn.com/problems/find-common-characters/
 * @author: libo
 * @date: 2020/10/14 9:40
 * @Version: 1.0
 */
@Slf4j
public class Q1002 {
    public static void main(String[] args) {
        System.out.println(new Q1002().commonChars(new String[]{"bella","label","roller"}));
    }
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> cnts = new HashMap<>();
        Map<Character, Integer> mins = new HashMap<>();
        for (String s : A) {
            Map<Character, Integer> ss = new HashMap<>();
            for (Character c : s.toCharArray()) {
                ss.put(c, ss.getOrDefault(c, 0) + 1);
            }
            for (Character c : ss.keySet()) {
                cnts.put(c, cnts.getOrDefault(c, 0) + 1);
                if (mins.getOrDefault(c,Integer.MAX_VALUE) > ss.get(c)) {
                    mins.put(c, ss.get(c));
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (Character c : cnts.keySet()) {
            if (cnts.get(c) == A.length) {
                for (int i = 0; i < mins.get(c); i++) {
                    res.add(String.valueOf(c));
                }
            }
        }

        return res;
    }
}
