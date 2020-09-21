package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Title: Q78
 * @Description: https://leetcode-cn.com/problems/subsets/
 * @author: libo
 * @date: 2020/9/20 20:00
 * @Version: 1.0
 */
@Slf4j
public class Q78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (begin >= nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, res);
            path.removeLast();
        }

    }
}
