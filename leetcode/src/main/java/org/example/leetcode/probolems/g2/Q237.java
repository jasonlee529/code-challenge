package org.example.leetcode.probolems.g2;

import cn.lee.leetcode.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q237
 * @Description: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author: libo
 * @date: 2020/9/23 11:54
 * @Version: 1.0
 */
@Slf4j
public class Q237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
