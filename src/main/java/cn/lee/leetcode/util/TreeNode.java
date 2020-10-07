package cn.lee.leetcode.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: TreeNode
 * @Description:
 * @author: libo
 * @date: 2020/9/10 13:49
 * @Version: 1.0
 */
@Slf4j
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
