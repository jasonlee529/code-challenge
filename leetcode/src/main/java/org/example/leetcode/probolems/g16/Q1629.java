package org.example.leetcode.probolems.g16;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q1629
 * @Description: https://leetcode-cn.com/problems/slowest-key/
 * @author: libo
 * @date: 2022/1/9 0009 20:02
 * @Version: 1.0
 */
@Slf4j
public class Q1629 {


    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int max = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int t = releaseTimes[i] - releaseTimes[i - 1];
            if (t > max) {
                max = t;
                res = keysPressed.charAt(i);
            } else if (t == max) {
                if (keysPressed.charAt(i) > res) {
                    res = keysPressed.charAt(i);
                }
            }
        }
        return res;
    }

    @Test
    public void test1() {
        Assert.assertEquals('c', slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
    }

    @Test
    public void test2() {
        Assert.assertEquals('a', slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
    }

}