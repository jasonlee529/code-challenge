package cn.lee.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static cn.lee.leetcode.util.TreeNodeFactory.build;

/**
 * @Title: Q112
 * @Description: https://leetcode-cn.com/problems/path-sum/
 * @author: libo
 * @date: 2020/9/10 15:43
 * @Version: 1.0
 */
@Slf4j
public class Q112 {
    public static void main(String[] args) {
        TreeNode h = build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
      //  System.out.println(new Q112().hasPathSum(h, 22));
        System.out.println(new Q112().hasPathSum(build(new Integer[]{1, 2}), 1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, sum, path, res);
        System.out.println(res);
        return res.size() > 0;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        } else {
            path.add(root.val);
            if (root.left == null && root.right == null) {
                if (sumPath(path) == sum) {
                    res.add(new ArrayList<>(path));
                }
            }
            if (root.left != null) {
                dfs(root.left, sum, path, res);
            }
            if (root.right != null) {
                dfs(root.right, sum, path, res);
            }
            path.removeLast();

        }
    }

    private int sumPath(Deque<Integer> path) {
        int sum = 0;
        for (int i : path) {
            sum += i;
        }
        return sum;
    }
}
