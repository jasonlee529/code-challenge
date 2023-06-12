package org.example.leetcode.probolems.g8;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/monotonic-array/
 */
public class Q896 {
    @Test
    public void test1() {
        Assert.assertEquals(true, isMonotonic(new int[]{1, 2, 2, 3}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(true, isMonotonic(new int[]{6, 5, 4, 4}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(false, isMonotonic(new int[]{1, 3, 2}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(true, isMonotonic(new int[]{1, 2, 4, 5}));
    }

    @Test
    public void test5() {
        Assert.assertEquals(true, isMonotonic(new int[]{1, 1, 1}));
    }

    @Test
    public void test6() {
        Assert.assertEquals(true, isMonotonic(new int[]{1, 1, 1, 2}));
    }

    @Test
    public void test7() {
        Assert.assertEquals(false, isMonotonic(new int[]{3, 4, 2, 3}));
    }

    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 1) {
            return true;
        }
        int len = A.length;

        boolean ans = true;
        int flag = 0;
        for (int i = 1; i < len; i++) {
            if (A[i - 1] > A[i] && flag <= 0) {
                flag = -1;
            } else if (A[i - 1] < A[i] && flag >= 0) {
                flag = 1;
            } else if (A[i - 1] == A[i]) {

            } else {
                ans = false;
            }
        }
        return ans;
    }
}
