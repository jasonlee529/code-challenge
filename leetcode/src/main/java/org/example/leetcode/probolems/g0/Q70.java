package org.example.leetcode.probolems.g0;import lombok.extern.slf4j.Slf4j;

/**
    * @Title: Q70
    * @Description: https://leetcode-cn.com/problems/climbing-stairs/
    * @author: libo
    * @date: 2020/9/1 19:35
    * @Version: 1.0
    */
@Slf4j
public class Q70 {

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
