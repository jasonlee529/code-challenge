package cn.lee.leetcode.probolems.g9;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q922
 * @Description: https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * @author: libo
 * @date: 2020/11/12 8:45
 * @Version: 1.0
 */
@Slf4j
public class Q922 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{4, 5, 2, 7}, sortArrayByParityII(new int[]{4, 2, 5, 7}));
    }

    public int[] sortArrayByParityII(int[] A) {
        if (A.length == 0) {
            return A;
        }
        int[] B = new int[A.length];
        int a = 0, b = 1;
        for (int m : A) {
            if (m % 2 == 0) {
                B[a] = m;
                a += 2;
            } else {
                B[b] = m;
                b += 2;
            }
        }
        return B;
    }
}
