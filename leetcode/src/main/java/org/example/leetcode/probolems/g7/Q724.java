package org.example.leetcode.probolems.g7;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @Title: Q724
 * @Description: https://leetcode-cn.com/problems/find-pivot-index/
 * @author: libo
 * @date: 2022/4/10 0010 20:32
 * @Version: 1.0
 */
@Slf4j
public class Q724 {

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    @Test
    public void test_1() {
        Assert.assertEquals(3, pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    @Test
    public void test_2() {
        Assert.assertEquals(-1, pivotIndex(new int[]{1, 2, 3}));
    }

    @Test
    public void test_3() {
        Assert.assertEquals(0, pivotIndex(new int[]{2, 1, -1}));
    }
}