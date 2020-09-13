package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q21
 * @Description: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author: libo
 * @date: 2020/9/7 17:39
 * @Version: 1.0
 */
@Slf4j
public class Q21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            ListNode node = null;
            if (l1 == null) {
                node = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }

            if (cur == null) {
                cur = node;
                head=cur;
            } else {
                cur.next = node;
                cur = node;
            }
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


