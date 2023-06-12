package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Title: Q103
 * @Description: https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @author: libo
 * @date: 2020/12/22 9:27
 * @Version: 1.0
 */
@Slf4j
public class Q103 {

    @Test
    public void test1() {
        Assert.assertEquals(new Integer[][]{{3}, {20, 9}, {15, 7}}, ((ArrayList) zigzagLevelOrder(TreeNodeFactory.build(new Integer[]{3, 9, 20, null, null, 15, 7}))).toString());
    }

    @Test
    public void test2() {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> level = new Stack<>();
        int le = 0;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(Arrays.asList(root.val));
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (le % 2 == 0) {
                if (node.right != null) {
                    level.add(node.right);
                }
                if (node.left != null) {
                    level.add(node.left);
                }
            } else {
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }
            if (stack.isEmpty() && !level.isEmpty()) {
                stack.addAll(level);
                List<Integer> l2 = new ArrayList<>();
                for (TreeNode n : level) {
                    l2.add(n.val);
                }
                res.add(l2);
                le++;
                level = new Stack<>();
            }
        }
        return res;
    }
}
