package cn.lee.leetcode.probolems.g2;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q234
 * @Description: https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author: libo
 * @date: 2020/10/10 13:56
 * @Version: 1.0
 */
@Slf4j
public class Q234 {
    public static void main(String[] args) {
        System.out.println(1^2^2^1);
        System.out.println(new Q234().isPalindrome(ListNodeFactory.build(new int[]{1,2,2,1})));
        System.out.println(new Q234().isPalindrome(ListNodeFactory.build(new int[]{1,2,2})));
    }
    //快慢指针
    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
