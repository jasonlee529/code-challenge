package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

/**
 * @Title: Q172
 * @Description: https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * @author: libo
 * @date: 2020/9/16 9:23
 * @Version: 1.0
 */
@Slf4j
public class Q172 {
    public static void main(String[] args) {
        System.out.println(new Q172().trailingZeroes(3));
        System.out.println(new Q172().trailingZeroes(5));
    }

    public int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }

    /**
     * 简单算法，超时风险-6955
     *
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {
        int cnt = 0;
        BigInteger bi = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        String num = bi.toString();
        for (int j = num.length() - 1; j >= 0; j--) {
            char c = num.charAt(j);
            if (c == '0') {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
