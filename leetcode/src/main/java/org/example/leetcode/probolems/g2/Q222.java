package org.example.leetcode.probolems.g2;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Title: Q222
 * @Description: https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * @author: libo
 * @date: 2020/11/24 9:02
 * @Version: 1.0
 */
@Slf4j
public class Q222 {
    @Test
    public void test() {
        Assert.assertEquals(6, countNodes(TreeNodeFactory.build(new Integer[]{1, 2, 3, 4, 5, 6})));
    }

    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int count = 0;
        if (root == null) {
            return 0;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            count++;
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return count;
    }
}
