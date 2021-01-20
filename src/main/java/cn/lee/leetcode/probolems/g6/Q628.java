package cn.lee.leetcode.probolems.g6;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

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

    public int maximumProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int sum = 1;
        for (int n : nums) {
            sum = sum * n;
        }
        return sum;
    }
}
