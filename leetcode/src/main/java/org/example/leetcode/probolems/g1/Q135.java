package org.example.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Title: Q135
 * @Description: https://leetcode-cn.com/problems/candy/
 * @author: libo
 * @date: 2020/12/24 13:58
 * @Version: 1.0
 */
@Slf4j
public class Q135 {

    @Test
    public void test1() {
        Assert.assertEquals(5, candy(new int[]{1, 0, 2}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, candy(new int[]{1, 2, 2}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(6, candy(new int[]{3, 2, 1}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(3, candy(new int[]{2, 1}));
    }

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        }
        int count = left[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }

    //爆破法
    public int candy3(int[] ratings) {
        int len = ratings.length;
        int[] pos = new int[len];
        boolean ans = true;
        while (ans) {
            ans = false;
            for (int i = 0; i < len - 1; i++) {
//                if (ratings[i - 1] > ratings[i] && pos[i - 1] <= pos[i]) {
//                    pos[i - 1] = pos[i] + 1;
//                    ans = true;
//                }
//                if (ratings[i - 1] < ratings[i] && pos[i - 1] >= pos[i]) {
//                    pos[i] = pos[i - 1] + 1;
//                    ans = true;
//                }
                if (ratings[i + 1] > ratings[i] && pos[i + 1] <= pos[i]) {
                    pos[i + 1] = pos[i] + 1;
                    ans = true;
                }
                if (ratings[i + 1] < ratings[i] && pos[i + 1] >= pos[i]) {
                    pos[i] = pos[i + 1] + 1;
                    ans = true;
                }
            }
        }
        int sum = 0;
        for (int n : pos) {
            sum = sum + n + 1;
        }
        return sum;
    }

    // 贪心法
    public int candy2(int[] ratings) {

        return 0;
    }
}
