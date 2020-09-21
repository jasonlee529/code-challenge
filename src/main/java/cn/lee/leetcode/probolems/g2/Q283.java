package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q283
 * @Description: https://leetcode-cn.com/problems/move-zeroes/
 * @author: libo
 * @date: 2020/9/21 16:37
 * @Version: 1.0
 */
@Slf4j
public class Q283 {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int right = len - 1;
        int pre = right;
        while (right >= 0) {
            if (nums[right] == 0) {
                for (int i = right; i <= pre; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[pre] = 0;
                pre--;
            }
            right--;
        }

    }
}
