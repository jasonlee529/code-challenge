package org.example.leetcode.probolems.g4;

import cn.lee.leetcode.util.Node;
import cn.lee.leetcode.util.Node3;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q430
 * @Description: https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * @author: libo
 * @date: 2021/9/24 9:54
 * @Version: 1.0
 */
@Slf4j
public class Q430 {


	@Test
	public void test1() {
	}

	public Node3 flatten(Node3 head) {
		dfs(head);
		return head;
	}

	public Node3 dfs(Node3 node) {
		Node3 cur = node;
		// 记录链表的最后一个节点
		Node3 last = null;

		while (cur != null) {
			Node3 next = cur.next;
			//  如果有子节点，那么首先处理子节点
			if (cur.child != null) {
				Node3 childLast = dfs(cur.child);

				next = cur.next;
				//  将 node 与 child 相连
				cur.next = cur.child;
				cur.child.prev = cur;

				//  如果 next 不为空，就将 last 与 next 相连
				if (next != null) {
					childLast.next = next;
					next.prev = childLast;
				}

				// 将 child 置为空
				cur.child = null;
				last = childLast;
			} else {
				last = cur;
			}
			cur = next;
		}
		return last;
	}
}
