package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q136
 * @Description: https://leetcode-cn.com/problems/single-number/
 * @author: libo
 * @date: 2020/9/15 11:14
 * @Version: 1.0
 */
@Slf4j
public class Q136 {
    public int singleNumber(int[] nums) {
        int n = 0;
        for (int i : nums) {
            n = n ^ i;
        }
        return n;
    }
}
