package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q10
 * @Description: https://leetcode-cn.com/problems/regular-expression-matching/
 * @author: libo
 * @date: 2020/12/23 15:58
 * @Version: 1.0
 */
@Slf4j
public class Q10 {
    @Test
    public void test1() {
        Assert.assertEquals(false, isMatch("aa", "a"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(true, isMatch("aa", "a*"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(true, isMatch("ab", ".*"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(true, isMatch("aab", "c*a*b"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(false, isMatch("mississippi", "mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {
        int left = 0, right = 0;
        boolean match = true;
        while (match && left < s.length() && right < p.length()) {

        }
        return true;
    }
}
