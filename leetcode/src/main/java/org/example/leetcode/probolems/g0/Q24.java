package org.example.leetcode.probolems.g0;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q24
 * @Description: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author: libo
 * @date: 2020/10/13 9:44
 * @Version: 1.0
 */
@Slf4j
public class Q24 {
    public static void main(String[] args) {
        System.out.println(new Q24().swapPairs(ListNodeFactory.build(new Integer[]{1, 2, 3, 4, 5})).toString());
    }

    public ListNode swapPairs(ListNode head) {
        int cnt = 0;
        int pre = 0;
        ListNode cur = head;
        while (cur != null) {
            if (cnt == 0) {
                pre = cur.val;
                if (cur.next != null) {
                    cur.val = cur.next.val;
                }
                cnt++;
            } else {
                cur.val = pre;
                cnt = 0;
            }
            cur = cur.next;
        }
        return head;
    }
}
