package cn.lee.leetcode.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: ListNodeFactory
 * @Description:
 * @author: libo
 * @date: 2020/9/18 13:41
 * @Version: 1.0
 */
@Slf4j
public class ListNodeFactory {
    public static ListNode build(int[] arr) {
        ListNode head = null;
        ListNode cur = null;
        for (int n : arr) {
            ListNode node = new ListNode(n);
            if (head == null) {
                cur = node;
                head = cur;
            } else {
                cur.next = node;
                cur = node;
            }
        }
        return head;
    }
}
