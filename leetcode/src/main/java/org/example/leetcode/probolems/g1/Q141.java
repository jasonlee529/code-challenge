package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.ListNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Title: Q141
 * @Description: https://leetcode-cn.com/problems/linked-list-cycle/
 * @author: libo
 * @date: 2020/9/15 11:31
 * @Version: 1.0
 */
@Slf4j
public class Q141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new LinkedHashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
