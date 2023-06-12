package org.example.leetcode.probolems.g5;

import cn.lee.leetcode.util.Node2;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Title: Q590
 * @Description: https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * @author: libo
 * @date: 2020/10/13 13:32
 * @Version: 1.0
 */
@Slf4j
public class Q590 {
    public static void main(String[] args) {
        Node2 head = new Node2(1);
        List<Node2> child = new ArrayList<>();
        child.add(new Node2(3));
        child.add(new Node2(2));
        child.add(new Node2(4));
        head.children = child;
        child.get(0).children = new ArrayList<>();
        child.get(0).children.add(new Node2((5)));
        child.get(0).children.add(new Node2((6)));
        System.out.println(new Q590().postorder(head));
    }

    public List<Integer> postorder(Node2 root) {
//        List<Integer> arr = new ArrayList<>();
//        Deque<Node2> deque = new ArrayDeque<>();
//        deque.add(root);
//        while (!deque.isEmpty()) {
//            Node2 node = deque.poll();
//            if (node.children != null) {
////                deque.push(node);
//                for (int i = node.children.size() - 1; i >= 0; i--) {
//                    deque.push(node.children.get(i));
//                }
//            } else {
////                arr.add(node.val);
//            }
//            arr.add(node.val);
//        }
//        return arr;
        LinkedList<Node2> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node2 node = stack.pollLast();
            output.addFirst(node.val);
            for (Node2 item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;

    }
}
