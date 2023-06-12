package org.example.leetcode.probolems.g13;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Title: Q1365
 * @Description: https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * @author: libo
 * @date: 2020/10/26 10:26
 * @Version: 1.0
 */
@Slf4j
public class Q1365 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Q1365().smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(new Q1365().smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            pos.putIfAbsent(sorted[i], i);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = pos.get(nums[i]);
        }
        return res;
    }
}
