package cn.lee.leetcode.interview.g08;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Title: Q01
 * @Description: https://leetcode-cn.com/problems/three-steps-problem-lcci/
 * @author: libo
 * @date: 2020/11/2 8:47
 * @Version: 1.0
 */
@Slf4j
public class Q01 {
    @Test
    public void test() {
//        Assert.assertEquals(1, new Q01().waysToStep(1));
//        Assert.assertEquals(2, new Q01().waysToStep(2));
//        Assert.assertEquals(4, new Q01().waysToStep(3));
        Assert.assertEquals(121415, new Q01().waysToStep(20));
        Assert.assertEquals(53798080, new Q01().waysToStep(30));
        Assert.assertEquals(752119970, new Q01().waysToStep(61));

    }

    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            long[] dp = new long[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i - 1]  +dp[i - 2] + dp[i - 3])%1000000007;
                System.out.println(i+"  "+dp[i]);
            }
            return (int)dp[n];
        }
    }

    public int waysToSte2p(int n) {

        int[] arr = null;
        if (n == 1) {
            arr = new int[]{1};
        } else if (n == 2) {
            arr = new int[]{1, 2};
        } else {
            arr = new int[]{1, 2, 3};
        }
        Map<String, Integer> maps = new HashMap<>();
        Stack<Integer> path = new Stack<>();
        dfs(arr, n, path, maps);
        return maps.keySet().size();
    }

    private void dfs(int[] arr, int n, Stack<Integer> path, Map<String, Integer> maps) {
        for (int m : arr) {
            path.add(m);
            int tmp = sum(path);
            if (tmp == n) {
                maps.put(toString2(path), 1);
            } else if (tmp > n) {
                path.pop();
                break;
            } else if (tmp < n) {
                dfs(arr, n, path, maps);
            }
            path.pop();
        }
    }

    private String toString2(Stack<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int n : path) {
            sb.append(n).append(",");
        }
        return sb.toString();
    }

    private int sum(Stack<Integer> path) {
        int sum = 0;
        for (int n : path) {
            sum += n;
        }
        return sum;
    }
}
