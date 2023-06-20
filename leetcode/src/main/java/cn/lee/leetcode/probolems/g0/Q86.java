package cn.lee.leetcode.probolems.g0;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q86
 * @Description: https://leetcode-cn.com/problems/partition-list/
 * @author: libo
 * @date: 2021/1/3 20:46
 * @Version: 1.0
 */
@Slf4j
public class Q86 {
    @Test
    public void test1() {
        Assert.assertEquals(ListNodeFactory.build(new int[]{1, 2, 2, 4, 3, 5}).toString(), partition(
                ListNodeFactory.build(new int[]{1, 4, 3, 2, 5, 2}), 3).toString());
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode xPre = null;
        ListNode xNode = null;
        if (head.val >= x) {
            xNode = head;
        }
        while (cur.next != null) {
            if (cur.next.val >= x) {
                if (xNode == null) {
                    xPre = cur;
                    xNode = cur.next;
                }
                cur = cur.next;
            } else if (cur.next.val < x) {
                if (xNode == null) {
                    cur = cur.next;
                } else {
                    ListNode node = cur.next;
                    cur.next = cur.next.next;
                    if (xPre == null) {
                        node.next = xNode;
                        xPre = node;
                    } else {
                        xPre.next = node;
                        node.next = xNode;
                        xPre = node;
                    }
                }
            }
        }
        return head;
    }
}
