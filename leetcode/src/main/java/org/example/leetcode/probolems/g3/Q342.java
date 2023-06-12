package org.example.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q342
 * @Description: https://leetcode-cn.com/problems/power-of-four/
 * @author: libo
 * @date: 2020/10/15 16:29
 * @Version: 1.0
 */
@Slf4j
public class Q342 {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        int i = 1;
        while (i>0&& i < num) {
            i = i * 4;
        }
        return i == num;
    }
}
