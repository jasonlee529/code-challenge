package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title: Q143
 * @Description: https://leetcode-cn.com/problems/reorder-list/
 * @author: libo
 * @date: 2020/10/20 10:56
 * @Version: 1.0
 */
@Slf4j
public class Q143 {
    public static void main(String[] args) {
        ListNode cur = ListNodeFactory.build(new Integer[]{1, 2, 3, 4});
        new Q143().reorderList(cur);
        System.out.println(cur);
    }

    public void reorderList(ListNode head) {
        if(head==null){
            return ;
        }
        Deque<ListNode> deque = new LinkedList<>();
        while (head != null) {
            deque.add(head);
            head = head.next;
        }
        head = deque.pollFirst();
        int i = 0;
        while (!deque.isEmpty()) {
            ListNode cur = null;
            if (i % 2 == 0) {
                cur = deque.pollLast();
            } else {
                cur = deque.pollFirst();
            }
            i++;
            head.next = cur;
            head = cur;
        }
        head.next = null;
    }
}
