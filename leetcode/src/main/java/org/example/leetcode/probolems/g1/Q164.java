package org.example.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Title: Q164
 * @Description: https://leetcode-cn.com/problems/maximum-gap/
 * @author: libo
 * @date: 2020/11/26 9:15
 * @Version: 1.0
 */
@Slf4j
public class Q164 {
    @Test
    public void test() {
        Assert.assertEquals(3, maximumGap(new int[]{3, 6, 9, 1}));
        Assert.assertEquals(0, maximumGap(new int[]{10}));
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = max >= (nums[i] - nums[i - 1]) ? max : (nums[i] - nums[i - 1]);
        }
        return max;
    }
}
