package org.example.leetcode.offer;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title: Q55
 * @Description: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @author: libo
 * @date: 2020/9/23 13:46
 * @Version: 1.0
 */
@Slf4j
public class Q55_1 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }
}
