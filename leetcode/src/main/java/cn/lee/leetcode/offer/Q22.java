package cn.lee.leetcode.offer;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q22
 * @Description: https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author: libo
 * @date: 2021/9/2 9:38
 * @Version: 1.0
 */
@Slf4j
public class Q22 {

	@Test
	public void test1() {
		Assert.assertEquals(ListNodeFactory.build(new Integer[]{4, 5}).toString(), getKthFromEnd(ListNodeFactory.build(new int[]{1, 2, 3, 4, 5}), 2).toString());
	}

	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode slow = head;
		while (k > 1 && head != null) {
			head = head.next;
			k--;
		}
		while (head != null && head.next != null) {
			head = head.next;
			slow = slow.next;
		}
		return slow;
	}
}
