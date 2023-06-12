package org.example.leetcode.probolems.g0;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q92
 * @Description: https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author: libo
 * @date: 2021/3/18 9:22
 * @Version: 1.0
 */
@Slf4j
public class Q92 {
	@Test
	public void test() {
		Assert.assertEquals(ListNodeFactory.build(new int[]{1, 4, 3, 2, 5}).toString(), reverseBetween(ListNodeFactory.build(new int[]{1, 2, 3, 4, 5}), 2, 4).toString());
	}

	public ListNode reverseBetween(ListNode head, int left, int right) {
		// 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;

		ListNode pre = dummyNode;
		// 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
		// 建议写在 for 循环里，语义清晰
		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
		}

		// 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
		ListNode rightNode = pre;
		for (int i = 0; i < right - left + 1; i++) {
			rightNode = rightNode.next;
		}

		// 第 3 步：切断出一个子链表（截取链表）
		ListNode leftNode = pre.next;
		ListNode curr = rightNode.next;

		// 注意：切断链接
		pre.next = null;
		rightNode.next = null;

		// 第 4 步：同第 206 题，反转链表的子区间
		reverseLinkedList(leftNode);

		// 第 5 步：接回到原来的链表中
		pre.next = rightNode;
		leftNode.next = curr;
		return dummyNode.next;
	}

	private void reverseLinkedList(ListNode head) {
		// 也可以使用递归反转一个链表
		ListNode pre = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
	}


	public ListNode reverseBetween2(ListNode head, int left, int right) {
		ListNode cur = head;
		int pos = 1;
		ListNode first = head;
		ListNode second = null;
		ListNode third = null;
		while (cur != null) {
			if (pos < left) {
				first = cur;
			} else if (pos > right) {
				third = cur;
				if (second != null) {

				}
				break;
			} else {
				if (second == null) {
					second = cur;
					first.next = null;
				}
			}
			if (pos == right) {
				ListNode pre = cur;
				cur = cur.next;
				pre.next = null;
			} else {
				cur = cur.next;
			}
			pos++;
		}
		second = reverse(second);
		first.next = second;
		while (second.next != null) {
			second = second.next;
		}
		second.next = third;
		return head;
	}

	private ListNode reverse(ListNode second) {
		ListNode pre = null;
		while (second != null) {
			ListNode tmp = second;
			second = second.next;
			tmp.next = pre;
			pre = tmp;
		}
		return second;
	}
}
