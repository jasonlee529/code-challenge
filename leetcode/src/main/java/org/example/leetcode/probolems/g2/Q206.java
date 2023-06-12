package org.example.leetcode.probolems.g2;

import cn.lee.leetcode.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q206
 * @Description: https://leetcode-cn.com/problems/reverse-linked-list/
 * @author: libo
 * @date: 2020/9/18 13:41
 * @Version: 1.0
 */
@Slf4j
public class Q206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
