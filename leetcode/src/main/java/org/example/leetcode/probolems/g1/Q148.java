package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q148
 * @Description: https://leetcode-cn.com/problems/sort-list/
 * @author: libo
 * @date: 2022/1/9 0009 22:54
 * @Version: 1.0
 */
@Slf4j
public class Q148 {
	public ListNode sortList(ListNode head) {
		return sortList(head, null);
	}

	public ListNode sortList(ListNode head, ListNode tail) {
		if (head == null) {
			return head;
		}
		if (head.next == tail) {
			head.next = null;
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast != tail) {
			slow = slow.next;
			fast = fast.next;
			if (fast != tail) {
				fast = fast.next;
			}
		}
		ListNode mid = slow;
		ListNode list1 = sortList(head, mid);
		ListNode list2 = sortList(mid, tail);
		ListNode sorted = merge(list1, list2);
		return sorted;
	}

	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
		while (temp1 != null && temp2 != null) {
			if (temp1.val <= temp2.val) {
				temp.next = temp1;
				temp1 = temp1.next;
			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		if (temp1 != null) {
			temp.next = temp1;
		} else if (temp2 != null) {
			temp.next = temp2;
		}
		return dummyHead.next;
	}

	public ListNode sortList2(ListNode head) {
		ListNode h1 = head;
		boolean f = false;
		ListNode cur = h1;
		ListNode pre = null;
		while (!f) {
			f = true;
			cur = h1;
			pre=null;
			while (cur != null && cur.next != null) {
				if (cur.val > cur.next.val) {
					cur = swap(cur, cur.next);
					f = false;
				}
				if (pre == null) {
					h1 = cur;
				}else{
					pre.next=cur;
				}
				pre = cur;
				cur = cur.next;
			}
		}
		return h1;
	}

	private ListNode swap(ListNode cur, ListNode next) {
		ListNode next2 = next;
		next = cur;
		next.next = next2.next;
		cur = next2;
		cur.next = next;
		return cur;
	}

	@Test
	public void test1() {
		Assert.assertEquals(ListNodeFactory.build(new int[]{1, 2, 3, 4}).toString(), sortList(ListNodeFactory.build(new int[]{4, 2, 1, 3})).toString());
	}

	@Test
	public void test2() {
		Assert.assertEquals(ListNodeFactory.build(new int[]{-1, 0, 3, 4, 5}).toString(), sortList(ListNodeFactory.build(new int[]{-1, 5, 3, 4, 0})).toString());
	}

	@Test
	public void test3() {
		Assert.assertEquals(null, sortList(ListNodeFactory.build(new int[]{})));
	}
}