package cn.lee.leetcode.weekly.w217;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q5614
 * @Description: https://leetcode-cn.com/problems/find-the-most-competitive-subsequence/
 * @author: libo
 * @date: 2020/11/29 13:48
 * @Version: 1.0
 */
@Slf4j
public class Q5614 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2, 6}, mostCompetitive(new int[]{3, 5, 2, 6}, 2));
        Assert.assertArrayEquals(new int[]{2, 3, 3, 4}, mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 6));
    }

    public int[] mostCompetitive(int[] nums, int k) {

        return null;
    }
}
