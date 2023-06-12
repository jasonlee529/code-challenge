package org.example.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: Q448
 * @Description: https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author: libo
 * @date: 2021/9/23 0023 23:20
 * @Version: 1.0
 */
@Slf4j
public class Q448 {

    @Test
    public void test1() {
        Assert.assertArrayEquals(new Integer[]{5, 6}, findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).toArray());
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new Integer[]{2}, findDisappearedNumbers(new int[]{1, 1}).toArray());
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}