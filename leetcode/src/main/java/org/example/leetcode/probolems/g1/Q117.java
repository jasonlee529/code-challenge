package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.Node;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title: Q117
 * @Description: https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @author: libo
 * @date: 2020/9/28 8:59
 * @Version: 1.0
 */
@Slf4j
public class Q117 {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Deque<Node> deque = new ArrayDeque<>();
        Deque<Node> sub = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            if (node.left != null) {
                sub.add(node.left);
            }
            if (node.right != null) {
                sub.add(node.right);
            }
            if (deque.isEmpty()) {
               deque.addAll(sub);
               sub.clear();
            } else {
                Node next = deque.getFirst();
                node.next = next;
            }
        }
        return root;
    }
}
