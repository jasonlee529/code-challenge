package org.example.leetcode.probolems.g3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q382
 * @Description: https://leetcode-cn.com/problems/linked-list-random-node/
 * @author: libo
 * @date: 2022/1/16 14:06
 * @Version: 1.0
 */
@Slf4j
public class Q382 {
	class Solution {
		private Queue<ListNode> queue = new LinkedList<>();
		public Solution(ListNode head) {
			while (head != null) {
				queue.offer(head);
				head = head.next;
			}
		}

		public int getRandom() {
			ListNode node = queue.poll();
			int res = node.val;
			queue.offer(node);
			return res;
		}
	}

	@Test
	public void test_1() {
		Solution solution = new Solution(ListNodeFactory.build(new Integer[]{1, 2, 3}));
		Assert.assertEquals(1,solution.getRandom());
		Assert.assertEquals(2,solution.getRandom());
		Assert.assertEquals(3,solution.getRandom());
		Assert.assertEquals(1,solution.getRandom());
		Assert.assertEquals(2,solution.getRandom());
		Assert.assertEquals(3,solution.getRandom());
	}

}
