package org.example.leetcode.probolems.g12;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Q1207
 * @Description: https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * @author: libo
 * @date: 2020/10/28 8:59
 * @Version: 1.0
 */
@Slf4j
public class Q1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : arr) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        Map<Integer, Integer> ss = new HashMap<>();
        for (Integer n : counts.keySet()) {
            if(ss.containsKey(counts.get(n))){
                return false;
            }else{
                ss.put(counts.get(n),1);
            }
        }
        return true;
    }
}
