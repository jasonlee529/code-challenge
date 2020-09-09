package cn.lee.leetcode.g1;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title: Q100
 * @Description:
 * @author: libo
 * @date: 2020/9/9 15:03
 * @Version: 1.0
 */
@Slf4j
public class Q100 {
    public static void main(String[] args) {
        Q100 q100 = new Q100();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(q100.isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean eq = true;
        Deque<TreeNode> pq = new LinkedList<>();
        Deque<TreeNode> qq = new LinkedList<>();
        pq.add(p);
        qq.add(q);
        while (eq && pq.size() > 0 && qq.size() > 0) {
            TreeNode n1 = pq.poll();
            TreeNode n2 = qq.poll();
            if (n1 != null && n2 != null) {
                eq = n1.val == n2.val;
                if (eq) {
                    pq.add(n1.left);
                    pq.add(n1.right);
                    qq.add(n2.left);
                    qq.add(n2.right);
                }
            } else if (n1 == null && n2 == null) {
                continue;
            } else {
                eq = false;
            }
        }
        return eq;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
