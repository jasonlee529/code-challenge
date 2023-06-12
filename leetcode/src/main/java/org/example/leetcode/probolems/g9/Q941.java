package org.example.leetcode.probolems.g9;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q941
 * @Description: https://leetcode-cn.com/problems/valid-mountain-array/
 * @author: libo
 * @date: 2020/11/3 9:04
 * @Version: 1.0
 */
@Slf4j
public class Q941 {
    @Test
    public void test() {
        Assert.assertEquals(false, new Q941().validMountainArray(new int[]{2, 1}));
        Assert.assertEquals(false, new Q941().validMountainArray(new int[]{3, 5, 5}));
        Assert.assertEquals(true, new Q941().validMountainArray(new int[]{0, 3, 2, 1}));
        Assert.assertEquals(false, new Q941().validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));
        Assert.assertEquals(false, new Q941().validMountainArray(new int[]{2,0,2}));
        Assert.assertEquals(true, new Q941().validMountainArray(new int[]{1,3,2}));
    }

    public boolean validMountainArray(int[] A) {
        boolean up = true;
        int peek = 0;
        for (int i = 1; i < A.length; i++) {
            if (up) {
                peek = i ;
                if (A[i] == A[i - 1]) {
                    return false;
                }
                if (A[i] < A[i - 1]) {
                    up = false;
                    peek = i - 1;
                }
            } else {
                if (A[i] >= A[i - 1]) {
                    return false;
                }
            }
        }
        System.out.println(peek);
        return A.length > 2&&peek<A.length-1&&peek>0;
    }
}
