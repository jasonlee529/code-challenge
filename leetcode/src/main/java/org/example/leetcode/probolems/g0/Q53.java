package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author libo
 * @Title: Q53
 * @Description: https://leetcode-cn.com/problems/maximum-subarray
 * @date 2020/9/1 19:33
 * @Version 1.0
 */
@Slf4j
public class Q53 {
    public static void main(String[] args) {
        System.out.println(new Q53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(Arrays.toString(new Q53().maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})));
    }

    public int maxSubArray(int[] nums) {

        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;

    }

    public int[] maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + nums[i]);
        }
        return dp;
    }
}
