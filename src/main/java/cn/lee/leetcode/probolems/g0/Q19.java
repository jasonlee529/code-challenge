package cn.lee.leetcode.probolems.g0;

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
        System.out.println(new Q19().removeNthFromEnd(ListNodeFactory.build(new int[]{1,2,3,4,5}),2));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (i < n+1) {
                fast = fast.next;
                i++;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return head;

    }
}
