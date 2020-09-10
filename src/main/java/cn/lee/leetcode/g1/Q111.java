package cn.lee.leetcode.g1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q111
 * @Description: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author: libo
 * @date: 2020/9/10 14:33
 * @Version: 1.0
 */
@Slf4j
public class Q111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

    private int len(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int l1 = len(node.left);
            int l2 = len(node.right);
            return Math.min(l1, l2) + 1;
        }
    }
}
