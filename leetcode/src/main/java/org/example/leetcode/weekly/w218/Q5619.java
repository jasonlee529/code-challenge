package org.example.leetcode.weekly.w218;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q5619
 * @Description: https://leetcode-cn.com/contest/weekly-contest-218/problems/minimum-incompatibility/
 * @author: libo
 * @date: 2020/12/6 11:04
 * @Version: 1.0
 */
@Slf4j
public class Q5619 {
    @Test
    public void test() {
        Assert.assertEquals(4, minimumIncompatibility(new int[]{1, 2, 1, 4}, 2));
        Assert.assertEquals(6, minimumIncompatibility(new int[]{6, 3, 8, 1, 3, 1, 2, 2}, 4));
        Assert.assertEquals(-1, minimumIncompatibility(new int[]{5, 3, 3, 6, 3, 3}, 3));
    }

    public int minimumIncompatibility(int[] nums, int k) {

        return 0;
    }
}
