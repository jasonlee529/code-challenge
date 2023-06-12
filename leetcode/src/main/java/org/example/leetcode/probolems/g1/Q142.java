package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q142
 * @Description: https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @author: libo
 * @date: 2020/10/10 8:47
 * @Version: 1.0
 */
@Slf4j
public class Q142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;
    }
}
