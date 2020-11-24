package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q414
 * @Description: https://leetcode-cn.com/problems/third-maximum-number/
 * @author: libo
 * @date: 2020/11/23 19:29
 * @Version: 1.0
 */
@Slf4j
public class Q414 {
    @Test
    public void test() {
        Assert.assertEquals(1, thirdMax(new int[]{2, 2, 3, 1}));
    }

    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int thrid = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n == first) {
                continue;
            }
            int t = Math.min(n, first);
            first = Math.max(n, first);
            if (n == second) {
                continue;
            }
            int t2 = Math.min(t, second);
            second = Math.max(second, t);
            if (n == thrid) {
                continue;
            }
            thrid = Math.max(thrid, t2);
        }
        return thrid == Integer.MIN_VALUE ? first : thrid;
    }
}
