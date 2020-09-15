package cn.lee.leetcode.probolems.g0;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title: Q94
 * @Description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author: libo
 * @date: 2020/9/14 9:35
 * @Version: 1.0
 */
@Slf4j
public class Q94 {
    public static void main(String[] args) {
        System.out.println(new Q94().inorderTraversal(TreeNodeFactory.build(new Integer[]{1, null, 2, 3})));
        System.out.println(new Q94().inOrderTraverse2(TreeNodeFactory.build(new Integer[]{1, null, 2, 3})));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        mid(root, res);
        return res;
    }

    public List<Integer> inOrderTraverse2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                res.add(node.val);
                pNode = node.right;
            }
        }
        return res;
    }

    private void mid(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            mid(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            mid(root.right, res);
        }
    }
}
