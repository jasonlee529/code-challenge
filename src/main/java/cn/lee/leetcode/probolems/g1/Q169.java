package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Q169
 * @Description: https://leetcode-cn.com/problems/majority-element/
 * @author: libo
 * @date: 2020/9/15 23:08
 * @Version: 1.0
 */
@Slf4j
public class Q169 {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i : nums) {
            if (cnts.containsKey(i)) {
                cnts.put(i, cnts.get(i)+1);
            } else {
                cnts.put(i, 1);
            }
        }
        int num = 0;
        for (Map.Entry<Integer, Integer> entry : cnts.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                num++;
            }
        }
        return num;
    }
}
