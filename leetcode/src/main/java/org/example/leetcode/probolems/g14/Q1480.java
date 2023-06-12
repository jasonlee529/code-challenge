package org.example.leetcode.probolems.g14;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1480
 * @Description: https://leetcode-cn.com/problems/running-sum-of-1d-array/
 * @author: libo
 * @date: 2021/8/28 0028 20:38
 * @Version: 1.0
 */
@Slf4j
public class Q1480 {

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1, 3, 6, 10}, runningSum(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, runningSum(new int[]{1, 1, 1, 1, 1}));
    }

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length ];
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                res[i]=nums[i];
            }else{
                res[i]=nums[i]+res[i-1];
            }
        }
        return res;
    }
}