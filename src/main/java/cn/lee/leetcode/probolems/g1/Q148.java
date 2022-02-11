package cn.lee.leetcode.probolems.g1;

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
		ListNode h1 = head;
		boolean f = false;
		ListNode cur = h1;
		while (!f) {
			while (cur != null && cur.next != null) {
                if(cur.val<cur.next.val){
                    swap(cur,cur.next);
                }
			}
		}
		return h1;
	}

	private void swap(ListNode cur, ListNode next) {
	}

	@Test
	public void test1() {
		Assert.assertEquals(ListNodeFactory.build(new int[]{1, 2, 3, 4}), sortList(ListNodeFactory.build(new int[]{4, 2, 1, 3})));
	}

	@Test
	public void test2() {
		Assert.assertEquals(ListNodeFactory.build(new int[]{-1, 0, 3, 4, 5}), sortList(ListNodeFactory.build(new int[]{-1, 5, 3, 4, 0})));
	}

	@Test
	public void test3() {
		Assert.assertEquals(ListNodeFactory.build(new int[]{}), sortList(ListNodeFactory.build(new int[]{})));
	}
}