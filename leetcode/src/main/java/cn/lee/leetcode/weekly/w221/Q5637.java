package cn.lee.leetcode.weekly.w221;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q5637
 * @Description: https://leetcode-cn.com/contest/weekly-contest-221/problems/determine-if-string-halves-are-alike/
 * @author: libo
 * @date: 2020/12/27 10:46
 * @Version: 1.0
 */
@Slf4j
public class Q5637 {

    @Test
    public void test1() {
        Assert.assertEquals(true, halvesAreAlike("book"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(false, halvesAreAlike("textbook"));
    }

    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String s1 = s.substring(0, len / 2);
        String s2 = s.substring(len / 2);
        return count(s1) == count(s2);
    }

    private int count(String s1) {
        int cnt = 0;
        for (char c : s1.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                cnt++;
            }
        }
        return cnt;
    }
}
