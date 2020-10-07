package cn.lee.leetcode.probolems.g7;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q701
 * @Description: https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * @author: libo
 * @date: 2020/9/30 11:53
 * @Version: 1.0
 */
@Slf4j
public class Q701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST(root.right, val);
            }
        }
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST(root.left, val);
            }
        }
        return root;
    }
}
