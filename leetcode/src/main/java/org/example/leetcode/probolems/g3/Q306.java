package org.example.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q306
 * @Description: https://leetcode-cn.com/problems/additive-number/
 * @author: libo
 * @date: 2022/1/10 0010 23:37
 * @Version: 1.0
 */
@Slf4j
public class Q306 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; ++secondStart) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; ++secondEnd) {
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                    break;
                }
                if (valid(secondStart, secondEnd, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valid(int secondStart, int secondEnd, String num) {
        int n = num.length();
        int firstStart = 0, firstEnd = secondStart - 1;
        while (secondEnd <= n - 1) {
            String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    public String stringAdd(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuffer third = new StringBuffer();
        int carry = 0, cur = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            cur = carry;
            if (firstEnd >= firstStart) {
                cur += s.charAt(firstEnd) - '0';
                --firstEnd;
            }
            if (secondEnd >= secondStart) {
                cur += s.charAt(secondEnd) - '0';
                --secondEnd;
            }
            carry = cur / 10;
            cur %= 10;
            third.append((char) (cur + '0'));
        }
        third.reverse();
        return third.toString();
    }

    public boolean isAdditiveNumber2(String num) {
        boolean res = false;
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                for (int k = j + 1; j < num.length(); k++) {
                    for (int m = k + 1; m < num.length(); m++) {
                        int t1 = Integer.parseInt(num.substring(i, j));
                        int t2 = Integer.parseInt(num.substring(j, k));
                        int t3 = Integer.parseInt(num.substring(k, m));
                        res &= (t1 + t2) == t3;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test1() {
        Assert.assertTrue(isAdditiveNumber("112358"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isAdditiveNumber("199100199"));
    }
}