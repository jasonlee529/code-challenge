package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title: Q101
 * @Description: https://leetcode-cn.com/problems/symmetric-tree/
 * @author: libo
 * @date: 2020/9/9 15:57
 * @Version: 1.0
 */
@Slf4j
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if(root.left ==null && root.right ==null){
            return true;
        }else if(root.left !=null && root.right !=null){
            return isSameTree(root.left,root.right);
        }else{
            return false;
        }
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
                    qq.add(n2.right);
                    qq.add(n2.left);
                }
            } else if (n1 == null && n2 == null) {
                continue;
            } else {
                eq = false;
            }
        }
        return eq;
    }


}
