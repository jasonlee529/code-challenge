package cn.lee.leetcode.probolems.g2;

import cn.lee.leetcode.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q203
 * @Description: https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author: libo
 * @date: 2020/9/17 11:38
 * @Version: 1.0
 */
@Slf4j
public class Q203 {
    public static void main(String[] args) {
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }
}
