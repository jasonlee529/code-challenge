package cn.lee.leetcode.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q69
 * @Description: https://leetcode-cn.com/problems/sqrtx/
 * @author: libo
 * @date: 2020/9/8 16:10
 * @Version: 1.0
 */
@Slf4j
public class Q69 {
    public static void main(String[] args) {
        System.out.println(new Q69().mySqrt(1));
        System.out.println(new Q69().mySqrt(100));
        System.out.println(new Q69().mySqrt(8));
    }

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
