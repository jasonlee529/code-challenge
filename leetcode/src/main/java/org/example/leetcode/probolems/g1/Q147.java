package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q147
 * @Description: https://leetcode-cn.com/problems/insertion-sort-list/
 * @author: libo
 * @date: 2020/11/20 13:35
 * @Version: 1.0
 */
@Slf4j
public class Q147 {
    @Test
    public void test() {
        Assert.assertEquals(ListNodeFactory.build(new Integer[]{1, 2, 3, 4}).toString(),
                insertionSortList(ListNodeFactory.build(new Integer[]{4, 2, 1, 3})).toString());
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        left.next = null;
        while (right != null) {
            ListNode node = right;
            right = right.next;
            left = insertInList(left, node);
        }
        return left;
    }

    private ListNode insertInList(ListNode left, ListNode node) {
        node.next = null;
        ListNode pre = null;
        ListNode cur = left;
        while (cur != null) {
            if (node.val >= cur.val) {
                if (cur.next == null) {
                    cur.next = node;
                    break;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            } else if (node.val < cur.val) {
                if (pre == null) {
                    node.next = cur;
                    left = node;
                    break;
                } else {
                    pre.next = node;
                    node.next = cur;
                    break;
                }
            }
        }
        return left;
    }
}
