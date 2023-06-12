package org.example.leetcode.weekly.w231;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q5698
 * @Description: https://leetcode-cn.com/contest/weekly-contest-231/problems/minimum-elements-to-add-to-form-a-given-sum/
 * @author: libo
 * @date: 2021/3/7 0007 10:50
 * @Version: 1.0
 */
@Slf4j
public class Q5698 {

    @Test
    public void tes1() {
        Assert.assertEquals(2, minElements(new int[]{1, -1, 1}, 3, -4));
    }

    @Test
    public void tes2() {
        Assert.assertEquals(1, minElements(new int[]{1, -10, 9, 1}, 100, 0));
    }

    public int minElements(int[] nums, int limit, int goal) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        sum = Math.abs(sum - goal);
        int cnt = 0;
        while (sum > 0) {
            sum = sum - limit;
            cnt++;
            if (sum <= 0) {
                sum = 0;
                break;
            }
        }
        return cnt;
    }
}