package org.example.leetcode.probolems.g2;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title: Q235
 * @Description: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author: libo
 * @date: 2020/9/24 10:58
 * @Version: 1.0
 */
@Slf4j
public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pathP = new ArrayDeque<>();
        Deque<TreeNode> pathQ = new ArrayDeque<>();
        getPath(root, p, pathP);
        getPath(root, q, pathQ);
        while (pathP.size() > 0 && pathQ.size() > 0) {
            TreeNode n1 = pathP.poll();
            TreeNode n2 = pathQ.poll();
            if (pathP.poll().val == pathQ.poll().val) {
                return n1;
            }
        }
        return null;
    }

    private void getPath(TreeNode root, TreeNode p, Deque<TreeNode> pathP) {
        if (root == null) {
            return;
        }
        if (root.val == p.val) {
            return;
        }
        pathP.add(root);
        getPath(root.left, p, pathP);
        pathP.removeLast();
        getPath(root.right, p, pathP);
        pathP.removeLast();
    }
}
