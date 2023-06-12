package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Title: Q113
 * @Description: https://leetcode-cn.com/problems/path-sum-ii/
 * @author: libo
 * @date: 2020/9/26 21:41
 * @Version: 1.0
 */
@Slf4j
public class Q113 {
    public static void main(String[] args) {
//        System.out.println(new Q113().pathSum(TreeNodeFactory.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
        System.out.println(new Q113().pathSum(TreeNodeFactory.build(new Integer[]{-2,null,-3}), -5));
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, sum, path, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        int tmp = sum(path);
        System.out.println(path + "  " + tmp);
        if (tmp == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            path.pollLast();
            return;
        }
        dfs(root.left, sum, path, res);
        dfs(root.right, sum, path, res);
        path.pollLast();

    }

    private int sum(Deque<Integer> path) {
        int sum = 0;
        for (int n : path) {
            sum += n;
        }
        return sum;
    }
}
