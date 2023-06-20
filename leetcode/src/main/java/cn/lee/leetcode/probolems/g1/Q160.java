package cn.lee.leetcode.probolems.g1;

import cn.lee.leetcode.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q160
 * @Description: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author: libo
 * @date: 2020/9/15 13:42
 * @Version: 1.0
 */
@Slf4j
public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
