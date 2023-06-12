package org.example.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q303
 * @Description:
 * @author: libo
 * @date: 2020/10/15 14:13
 * @Version: 1.0
 */
@Slf4j
public class Q303 {
    int[] ns;

    public Q303(int[] nums) {
        ns = nums;
    }

    public int sumRange(int i, int j) {
        int res = 0;
        for (int s = i; s <= j && j < ns.length; s++) {
            res += ns[s];
        }
        return res;
    }
}
