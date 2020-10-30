package cn.lee.leetcode.probolems.g10;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q1024
 * @Description: https://leetcode-cn.com/problems/divisor-game/solution/chu-shu-bo-yi-by-leetcode-solution/
 * @author: libo
 * @date: 2020/10/30 16:46
 * @Version: 1.0
 */
@Slf4j
public class Q1024 {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public boolean divisorGame2(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[0] = false;
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {

            }
        }
        return dp[N];
    }
}
