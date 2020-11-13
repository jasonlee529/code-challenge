package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Title: Q31
 * @Description: https://leetcode-cn.com/problems/next-permutation/
 * @author: libo
 * @date: 2020/11/10 12:31
 * @Version: 1.0
 */
@Slf4j
public class Q31 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 3, 2}, nextPermutation(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, nextPermutation(new int[]{3, 2, 1}));
        Assert.assertArrayEquals(new int[]{2, 1, 3}, nextPermutation(new int[]{1, 3, 2}));
        Assert.assertArrayEquals(new int[]{4, 2, 0, 3, 0, 2, 2}, nextPermutation(new int[]{4, 2, 0, 2, 3, 2, 0}));
    }

    public int[] nextPermutation(int[] nums) {
        int left = nums.length - 2, right = nums.length - 1;
        boolean is = true;
            for (int i = left; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    is = false;
                    left = i;
                    right = i + 1;
                    break;
                }
            }
        System.out.println(left + " " + right);
        System.out.println(Arrays.toString(nums));
        if (left >= 0) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
        }
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums, left , nums.length);
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
