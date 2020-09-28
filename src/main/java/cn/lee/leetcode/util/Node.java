package cn.lee.leetcode.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Node
 * @Description:
 * @author: libo
 * @date: 2020/9/28 8:59
 * @Version: 1.0
 */
@Slf4j
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
