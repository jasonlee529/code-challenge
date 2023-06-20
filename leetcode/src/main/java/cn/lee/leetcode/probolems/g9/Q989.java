package cn.lee.leetcode.probolems.g9;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: Q989
 * @Description: https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 * @author: libo
 * @date: 2021/1/22 9:22
 * @Version: 1.0
 */
@Slf4j
public class Q989 {
    @Test
    public void test1() {
        Assert.assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)), addToArrayForm(new int[]{1, 2, 0, 0}, 34));
    }

    @Test
    public void test2() {
        Assert.assertEquals(new ArrayList<Integer>(Arrays.asList(4, 5, 5)), addToArrayForm(new int[]{2, 7, 4}, 181));
    }

    @Test
    public void test3() {
        Assert.assertEquals(new ArrayList<Integer>(Arrays.asList(1, 0, 2, 1)), addToArrayForm(new int[]{2, 1, 5}, 806));
    }

    @Test
    public void test4() {
        Assert.assertEquals(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)), addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }
    @Test
    public void test5() {
        Assert.assertEquals(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0)), addToArrayForm(new int[]{1}, 999999999));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int plus = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int t = A[i] + plus + K % 10;
            plus = t / 10;
            res.add(0, t % 10);
            K = K / 10;
        }
        while (K > 0) {
            int t = plus + K % 10;
            plus = t / 10;
            res.add(0, t % 10);
            K = K / 10;
        }
        if (plus == 1) {
            res.add(0, plus);
        }
        return res;
    }
}
