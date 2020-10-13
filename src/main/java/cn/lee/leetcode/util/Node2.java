package cn.lee.leetcode.util;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Title: Node2
 * @Description:
 * @author: libo
 * @date: 2020/10/13 11:05
 * @Version: 1.0
 */
@Slf4j
public class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {
    }

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, List<Node2> _children) {
        val = _val;
        children = _children;
    }
}
