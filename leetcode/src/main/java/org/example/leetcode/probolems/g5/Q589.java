package org.example.leetcode.probolems.g5;

import cn.lee.leetcode.util.Node2;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q589
 * @Description: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @author: libo
 * @date: 2020/10/13 11:04
 * @Version: 1.0
 */
@Slf4j
public class Q589 {
    public List<Integer> preorder(Node2 root) {
        List<Integer> arr = new ArrayList<>();
        preorder2(root, arr);
        return arr;
    }

    private void preorder2(Node2 root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        arr.add(root.val);
        if (root.children != null) {
            for (Node2 node : root.children) {
                preorder2(node, arr);
            }
        }
    }
}
