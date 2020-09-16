package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q190
 * @Description: https://leetcode-cn.com/problems/reverse-bits/
 * @author: libo
 * @date: 2020/9/16 11:43
 * @Version: 1.0
 */
@Slf4j
public class Q190 {
    public static void main(String[] args) {
        System.out.println(new Q190().reverseBits(43261596));
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
    public int reverseBits2(int n) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (n != 0) {
            sb.append(n % 2);
            n = n / 2;
            k++;
        }

        while(k<32){
            sb.append(0);
            k++;
        }
        int res = 0;
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            int t = 0;
            if (s.charAt(i) == '1') {
                t = 1;
            }
            res = res * 2 + t;
        }
        return res;
    }
}
