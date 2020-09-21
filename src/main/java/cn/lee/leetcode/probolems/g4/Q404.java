package cn.lee.leetcode.probolems.g4;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q404
 * @Description: https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @author: libo
 * @date: 2020/9/20 20:06
 * @Version: 1.0
 */
@Slf4j
public class Q404 {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;

    }
}
