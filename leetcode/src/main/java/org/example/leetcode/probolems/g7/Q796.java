package org.example.leetcode.probolems.g7;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q769
 * @Description: https://leetcode-cn.com/problems/rotate-string/
 * @author: libo
 * @date: 2022/4/7 0007 22:50
 * @Version: 1.0
 */
@Slf4j
public class Q796 {
    public boolean rotateString(String s, String goal) {
        boolean match = false;
        if (s.length() != goal.length()) {
            return match;
        }
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            match = true;
            for (int j = 0; j < len; j++) {
                if (s.charAt((i + j) % len) != goal.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                break;
            }
        }
        return match;
    }

    @Test
    public void test_1() {
        Assert.assertEquals(true, rotateString("abcde", "cdeab"));
    }

    @Test
    public void test_2() {
        Assert.assertEquals(false, rotateString("abcde", "abced"));
    }
    @Test
    public void test_3() {
        Assert.assertEquals(false, rotateString("aa", "a"));
    }
}