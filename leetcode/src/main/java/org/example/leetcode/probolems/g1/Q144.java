package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Title: Q144
 * @Description: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @author: libo
 * @date: 2020/10/27 8:59
 * @Version: 1.0
 */
@Slf4j
public class Q144 {
    public static void main(String[] args) {
        System.out.println(new Q144().preorderTraversal(TreeNodeFactory.build(new Integer[]{1, null, 2, 3})));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                res.add(node.val);
                stack.add(node.right);
                stack.add(node.left);
            }
        }
        return res;
    }
}
