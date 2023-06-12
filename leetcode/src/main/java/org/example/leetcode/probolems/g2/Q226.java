package org.example.leetcode.probolems.g2;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q226
 * @Description: https://leetcode-cn.com/problems/invert-binary-tree/
 * @author: libo
 * @date: 2020/9/16 9:13
 * @Version: 1.0
 */
@Slf4j
public class Q226 {

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }
}
