package org.example.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q860
 * @Description: https://leetcode-cn.com/problems/lemonade-change/
 * @author: libo
 * @date: 2020/12/10 10:04
 * @Version: 1.0
 */
@Slf4j
public class Q860 {

    @Test
    public void test() {
        Assert.assertEquals(true, lemonadeChange(new int[]{5, 5, 10}));
        Assert.assertEquals(true, lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        Assert.assertEquals(false, lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        Assert.assertEquals(false, lemonadeChange(new int[]{5,5,5,10,5,5,10,20,20,20}));
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        boolean suc = true;
        for (int n : bills) {
            if (n == 5) {
                five++;
            }
            if (n == 10) {
                if (five >= 1) {
                    five--;
                    ten++;
                } else {
                    suc = false;
                    break;
                }
            }
            if (n == 20) {
                if (ten == 0 && five >= 3) {
                    five -= 3;
                    twenty++;
                } else if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                    twenty++;
                } else {
                    suc = false;
                    break;
                }
            }
        }
        return suc;
    }
}
