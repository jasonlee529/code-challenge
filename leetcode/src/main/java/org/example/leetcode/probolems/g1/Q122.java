package org.example.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Title: Q122
 * @Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author: libo
 * @date: 2020/9/14 17:12
 * @Version: 1.0
 */
@Slf4j
public class Q122 {
    public static void main(String[] args) {
        System.out.println(new Q122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Q122().maxProfit(new int[]{1, 7, 4, 2}));
    }
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    public int maxProfit2(int[] prices) {
        Deque<Integer[]> path = new ArrayDeque<>();
        List<Integer> maxs = new ArrayList<>();
        dfs(prices, 0, path, maxs);
        Collections.sort(maxs);
        return maxs.size() > 0 ? maxs.get(maxs.size() - 1) : 0;
    }

    private void dfs(int[] prices, int begin, Deque<Integer[]> path, List<Integer> maxs) {
        if (begin >= prices.length - 1) {
            maxs.add(sum(path));
            return;
        }
        for (int i = begin; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    path.add(new Integer[]{prices[i], prices[j]});
                    dfs(prices, j + 1, path, maxs);
                    maxs.add(sum(path));
                    path.removeLast();
                }
            }
        }
    }

    private Integer sum(Deque<Integer[]> path) {
        int sum = 0;
        for (Integer[] a : path) {
            sum += a[1] - a[0];
        }
        return sum;

    }
}
