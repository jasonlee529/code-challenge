package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q485
 * @Description: https://leetcode-cn.com/problems/max-consecutive-ones/
 * @author: libo
 * @date: 2020/9/27 11:38
 * @Version: 1.0
 */
@Slf4j
public class Q485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = tmp > max ? tmp : max;
                tmp = 0;
            } else {
                tmp++;
            }
        }
        return max;
    }
}
