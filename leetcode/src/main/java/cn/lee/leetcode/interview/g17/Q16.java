package cn.lee.leetcode.interview.g17;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q16
 * @Description: https://leetcode-cn.com/problems/the-masseuse-lcci/
 * @author: libo
 * @date: 2020/10/27 11:41
 * @Version: 1.0
 */
@Slf4j
public class Q16 {
    public int massage2(int[] nums) {
        int m = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                m += nums[i];
            } else {
                n += nums[i];
            }
        }
        return Math.max(m, n);
    }

    public static void main(String[] args) {
        System.out.println(new Q16().massage(new int[]{2, 1, 1, 2}));
        System.out.println(new Q16().massage(new int[]{1, 2, 3, 4}));
    }

    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = 0, dp1 = nums[0];

        for (int i = 1; i < n; ++i) {
            System.out.print(i + " " + nums[i] + " pre: " + dp0 + " " + dp1);

            int tdp0 = Math.max(dp0, dp1); // 计算 dp[i][0]
            int tdp1 = dp0 + nums[i]; // 计算 dp[i][1]

            dp0 = tdp0; // 用 dp[i][0] 更新 dp_0
            dp1 = tdp1; // 用 dp[i][1] 更新 dp_1
            System.out.println(" after: " + dp0 + " " + dp1);

        }
        return Math.max(dp0, dp1);
    }

    public int f(int[] nums, int i) {
        if (i < 2) {
            return nums[i];
        }
        int pre = Math.max(f(nums, i - 2) + nums[i], f(nums, i - 1));
        return pre;
    }

    public int massage3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
