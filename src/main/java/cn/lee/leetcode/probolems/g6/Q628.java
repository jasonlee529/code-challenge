package cn.lee.leetcode.probolems.g6;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Title: Q628
 * @Description:
 * @author: libo
 * @date: 2021/1/20 15:59
 * @Version: 1.0
 */
@Slf4j
public class Q628 {
    @Test
    public void test1() {
        Assert.assertEquals(6, maximumProduct(new int[]{1, 2, 3}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(24, maximumProduct(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, maximumProduct(new int[]{}));
    }
    @Test
    public void test4() {
        Assert.assertEquals(39200, maximumProduct(new int[]{-100,-98,-1,2,3,4}));
    }
    public int maximumProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 1;
        int len = nums.length;
        int t1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int t2 = nums[0] < 0 ? nums[len - 1] * nums[0] * nums[1] : nums[0];
        return Math.max(t1, t2);
    }
}
