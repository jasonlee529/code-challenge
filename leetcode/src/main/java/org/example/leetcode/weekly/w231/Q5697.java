package org.example.leetcode.weekly.w231;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q5697
 * @Description: https://leetcode-cn.com/contest/weekly-contest-231/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 * @author: libo
 * @date: 2021/3/7 0007 10:43
 * @Version: 1.0
 */
@Slf4j
public class Q5697 {
    @Test
    public void tes1() {
        Assert.assertEquals(false, checkOnesSegment("1001"));
    }

    @Test
    public void tes2() {
        Assert.assertEquals(true, checkOnesSegment("110"));
    }

    public boolean checkOnesSegment(String s) {
        boolean ans = true;
        boolean one = false;
        char pre = '0';
        for (Character c : s.toCharArray()) {
            if (pre == '1' && c == '0') {
                one = true;
            }
            if (one == true && c == '1') {
                ans = false;
            }
            pre = c;
        }
        return ans;
    }
}