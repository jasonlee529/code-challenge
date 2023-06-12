package org.example.leetcode.probolems.g13;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Title: Q1356
 * @Description: https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 * @author: libo
 * @date: 2020/11/6 8:47
 * @Version: 1.0
 */
@Slf4j
public class Q1356 {
    @Test
    public void test() {
        //Assert.assertArrayEquals(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}, sortByBits(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7}, sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
    }

    public int[] sortByBits(int[] arr) {
        int[][] arr2 = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int bit = count(arr[i]);
            arr2[i] = new int[]{arr[i], bit};
        }
        Arrays.sort(arr2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for (int i = 0; i < arr2.length; i++) {
            arr[i] = arr2[i][0];
        }
        return arr;
    }

    @Test
    public void testCount() {
        Assert.assertEquals(2, count(3));
        Assert.assertEquals(1, count(4));
        Assert.assertEquals(0, count(0));
    }

    private int count(int i) {
        int cnt = 0;
        while (i > 0) {
            cnt += i % 2 == 1 ? 1 : 0;
            i = i / 2;
        }
        return cnt;
    }
}
