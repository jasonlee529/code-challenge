package org.example.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title: Q202
 * @Description: https://leetcode-cn.com/problems/happy-number/
 * @author: libo
 * @date: 2020/9/17 11:03
 * @Version: 1.0
 */
@Slf4j
public class Q202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int num = 0;
            while (n != 0) {
                int t = n % 10;
                num += t * t;
                n = n / 10;
            }
            if (set.contains(num)) {
                return false;
            }
            n = num;
        }
        return true;
    }
}
