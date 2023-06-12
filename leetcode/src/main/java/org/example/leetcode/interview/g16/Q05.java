package org.example.leetcode.interview.g16;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q05
 * @Description:
 * @author: libo
 * @date: 2021/9/8 0008 22:57
 * @Version: 1.0
 */
@Slf4j
public class Q05 {
    @Test
    public void test1() {
        Assert.assertEquals(0, trailingZeroes(3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, trailingZeroes(6));
    }

    public int trailingZeroes(int n) {
        int cnt = 0;
        for (long num = 5; n / num > 0; num *= 5) {
            cnt += n / num;
        }
        return cnt;
    }
}