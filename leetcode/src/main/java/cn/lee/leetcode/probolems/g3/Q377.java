package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Title: Q377
 * @Description: https://leetcode-cn.com/problems/combination-sum-iv/
 * @author: libo
 * @date: 2021/4/24 0024 23:15
 * @Version: 1.0
 */
@Slf4j
public class Q377 {
    @Test
    public void test1() {
        Assert.assertEquals(7, combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        Stack<Integer> path = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, target, path, res);
        return res.size();
    }

    private void dfs(int[] nums, int begin, int target, Stack<Integer> path, List<List<Integer>> res) {
        if (begin >= nums.length) {
            return;
        }
        int sum = sum(path);
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, begin, target, path, res);
            path.pop();
        }
    }

    private int sum(Stack<Integer> path) {
        int sum = 0;
        for (int n : path) {
            sum += n;
        }
        return sum;
    }
}