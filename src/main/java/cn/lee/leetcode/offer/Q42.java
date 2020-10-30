package cn.lee.leetcode.offer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q42
 * @Description: https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author: libo
 * @date: 2020/10/30 17:10
 * @Version: 1.0
 */
@Slf4j
public class Q42 {
    @Test
    public void test() {
        Assert.assertEquals(new Q42().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
    }

    public int maxSubArray(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int n : nums) {
            if (sum >= 0) {
                sum += n;
            } else {
                sum = n;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
