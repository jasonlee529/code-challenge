package cn.lee.leetcode.probolems.g0;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q82
 * @Description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @author: libo
 * @date: 2021/3/25 9:24
 * @Version: 1.0
 */
@Slf4j
public class Q82 {


	@Test
	public void test1() {
		Assert.assertEquals(ListNodeFactory.build(new Integer[]{1, 2, 5}).toString(), deleteDuplicates(ListNodeFactory.build(new int[]{1, 2, 3, 3, 4, 4, 5})).toString());
	}

	@Test
	public void test2() {
		Assert.assertEquals(ListNodeFactory.build(new Integer[]{2, 3}).toString(), deleteDuplicates(ListNodeFactory.build(new int[]{1, 1, 1, 2, 3})).toString());
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.next.val == cur.val) {
				int val = cur.val;
				while (cur.next != null && cur.next.val == val) {
					cur = cur.next;
				}
				if (val == head.val) {
					head = cur.next;
				} else {
					if (pre == null) {
						pre = cur;
					} else {
						pre.next = cur.next;
						cur=cur.next;
					}
				}
			} else {
				pre=cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
