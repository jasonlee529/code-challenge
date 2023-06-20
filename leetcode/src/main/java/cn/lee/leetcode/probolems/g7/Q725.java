package cn.lee.leetcode.probolems.g7;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q725
 * @Description: https://leetcode-cn.com/problems/split-linked-list-in-parts/
 * @author: libo
 * @date: 2021/9/22 0022 21:00
 * @Version: 1.0
 */
@Slf4j
public class Q725 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new ListNode[]{ListNodeFactory.build(new Integer[]{1}),
                        ListNodeFactory.build(new Integer[]{2}),
                        ListNodeFactory.build(new Integer[]{3}),
                        ListNodeFactory.build(new Integer[]{}),
                        ListNodeFactory.build(new Integer[]{})},
                splitListToParts(ListNodeFactory.build(new Integer[]{1, 2, 3}), 5));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new ListNode[]{ListNodeFactory.build(new Integer[]{1, 2, 3, 4}),
                        ListNodeFactory.build(new Integer[]{5, 6, 7}),
                        ListNodeFactory.build(new Integer[]{8, 9, 10})
                },
                splitListToParts(ListNodeFactory.build(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3));
    }


    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur=head;
        int bucket = len / k;
        int dev = len % k;
        ListNode[] res = new ListNode[bucket];
        ListNode pre=null;
        int index=0;
        while (index < bucket) {
            
        }
        return null;
    }
}