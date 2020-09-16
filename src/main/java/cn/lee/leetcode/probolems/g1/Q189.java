package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q189
 * @Description: https://leetcode-cn.com/problems/rotate-array/
 * @author: libo
 * @date: 2020/9/16 10:25
 * @Version: 1.0
 */
@Slf4j
public class Q189 {
    public void rotate(int[] nums, int k) {

    }

    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k % len; i++) {
            int t = nums[len - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = t;
        }
    }
}
