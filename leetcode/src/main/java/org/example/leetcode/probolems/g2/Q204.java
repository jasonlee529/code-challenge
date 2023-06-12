package org.example.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q204
 * @Description: https://leetcode-cn.com/problems/count-primes/
 * @author: libo
 * @date: 2020/9/17 12:01
 * @Version: 1.0
 */
@Slf4j
public class Q204 {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }

    public int countPrimes2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (isZ(i)) {
                sum++;
            }
        }
        return sum;
    }

    private boolean isZ(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
