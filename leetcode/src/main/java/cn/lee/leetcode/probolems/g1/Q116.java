package cn.lee.leetcode.probolems.g1;

import cn.lee.leetcode.util.Node;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title: Q116
 * @Description: https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @author: libo
 * @date: 2020/10/15 9:54
 * @Version: 1.0
 */
@Slf4j
public class Q116 {
    public Node connect(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Deque<Node> level = new ArrayDeque<>();
        stack.push(root);
        Node pre = null;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.val);
            if (node.left != null) {
                level.add(node.left);
            }
            if (node.right != null) {
                level.add(node.right);
            }
            if (pre != null) {
                pre.next = node;
            }
            pre = node;
            if (stack.isEmpty()) {
                pre = null;
                stack = level;
                level = new ArrayDeque<>();
            }
        }
        return root;
    }
}
