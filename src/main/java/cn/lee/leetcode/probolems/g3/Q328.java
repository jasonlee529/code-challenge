package cn.lee.leetcode.probolems.g3;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q328
 * @Description: https://leetcode-cn.com/problems/odd-even-linked-list/
 * @author: libo
 * @date: 2020/11/13 8:58
 * @Version: 1.0
 */
@Slf4j
public class Q328 {
    @Test
    public void test() {
        Assert.assertEquals(ListNodeFactory.build(new int[]{1, 3, 5, 2, 4}).toString(), oddEvenList(ListNodeFactory.build(new int[]{1, 2, 3, 4, 5})).toString());
        Assert.assertEquals(ListNodeFactory.build(new int[]{1, 3, 5, 7, 2, 4, 6, 8}).toString(), oddEvenList(ListNodeFactory.build(new int[]{1, 2, 3, 4, 5, 6, 7, 8})).toString());
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }

    public ListNode oddEvenList2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                fast = fast.next;
            }
        }
        ListNode half = slow;
        slow = slow.next;
        half.next = null;
        ListNode insert = slow;
        while (slow != null) {
            ListNode next = slow.next;
            ListNode next2 = next == null ? null : next.next;
            next.next = insert;
            slow.next = next2;
        }
        return insert;
    }
}
