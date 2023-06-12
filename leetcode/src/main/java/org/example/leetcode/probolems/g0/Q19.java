package org.example.leetcode.probolems.g0;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q19
 * @Description: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author: libo
 * @date: 2020/10/18 23:05
 * @Version: 1.0
 */
@Slf4j
public class Q19 {
    public static void main(String[] args) {
        System.out.println(new Q19().removeNthFromEnd(ListNodeFactory.build(new Integer[]{1, 2, 3, 4, 5}), 2));
        System.out.println(new Q19().removeNthFromEnd(ListNodeFactory.build(new Integer[]{1,2}), 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
//慢指针比快指针慢N步,那么快指针指向末尾的null时,慢指针刚好指向要删除结点的前驱结点
        while (fast.next != null) {
            fast = fast.next;
            if (n == 0) {
                slow = slow.next;
            } else {
                n--;
            }
        }
        if (n != 0) { //没追上,说明删除的是头指针
            return head.next;
        } else {
            slow.next = slow.next.next;
        }
        return head;

    }
}
