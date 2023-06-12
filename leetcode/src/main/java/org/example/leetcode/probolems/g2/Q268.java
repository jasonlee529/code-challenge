package org.example.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q268
 * @Description: https://leetcode-cn.com/problems/missing-number/
 * @author: libo
 * @date: 2020/9/25 10:48
 * @Version: 1.0
 */
@Slf4j
public class Q268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return 0;
    }
}
