package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q75
 * @Description: https://leetcode-cn.com/problems/sort-colors/
 * @author: libo
 * @date: 2020/10/7 22:11
 * @Version: 1.0
 */
@Slf4j
public class Q75 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Q75().sortColors(new int[]{2,0,2,1,1,0})));
        System.out.println(Arrays.toString(new Q75().sortColors(new int[]{1,2,0})));
    }
    public int[] sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0 && i >= left) {
                swap(nums, i, left);
                left++;
                i--;
            }
            if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                i--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int right) {
        int t = nums[i];
        nums[i] = nums[right];
        nums[right] = t;

    }
}
