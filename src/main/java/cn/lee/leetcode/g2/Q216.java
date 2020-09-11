package cn.lee.leetcode.g2;

import cn.lee.leetcode.util.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Title: Q216
 * @Description: https://leetcode-cn.com/problems/combination-sum-iii/
 * @author: libo
 * @date: 2020/9/11 9:17
 * @Version: 1.0
 */
@Slf4j
public class Q216 {
    public static void main(String[] args) {
        System.out.println(new Q216().combinationSum3(3, 7));
        System.out.println(new Q216().combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(k, n, 1, path, res);
        return res;
    }

    private void dfs(int k, int n, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            if (Utils.sumPath(path) == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = begin; i <= 9; i++) {
            path.add(i);
            dfs(k, n, i + 1, path, res);
            path.removeLast();
        }
    }
}
