package org.example.leetcode.probolems.g9;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Title: Q976
 * @Description: https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * @author: libo
 * @date: 2020/11/29 12:04
 * @Version: 1.0
 */
@Slf4j
public class Q976 {
    @Test
    public void test() {
        Assert.assertEquals(0, largestPerimeter(new int[]{}));
        Assert.assertEquals(5, largestPerimeter(new int[]{2, 1, 2}));
        Assert.assertEquals(0, largestPerimeter(new int[]{1, 2, 1}));
        Assert.assertEquals(8, largestPerimeter(new int[]{3, 6, 2, 3}));
        Assert.assertEquals(10, largestPerimeter(new int[]{3, 2, 3, 4}));

    }

    public int largestPerimeter(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        Arrays.sort(A);
        int max = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int t = isTriangle(A[i], A[i + 1], A[i + 2]);
            max = max > t ? max : t;
        }
        return max;
    }

    public int isTriangle(int a, int b, int c) {
        if (a + b > c && c - b < a) {
            return a + b + c;
        } else {
            return 0;
        }
    }
}
