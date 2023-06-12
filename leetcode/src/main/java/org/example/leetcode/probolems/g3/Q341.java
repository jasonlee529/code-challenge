package org.example.leetcode.probolems.g3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q341
 * @Description: https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * @author: libo
 * @date: 2021/3/23 9:49
 * @Version: 1.0
 */
@Slf4j
public class Q341 {

	class NestedIterator implements Iterator<Integer> {
		List<NestedInteger> nestedList = null;
		Deque<Integer> queue = new ArrayDeque<>();

		public NestedIterator(List<NestedInteger> nestedList) {
			dfs(nestedList);
		}

		@Override
		public Integer next() {
			return hasNext() ? queue.pollFirst() : -1;
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		void dfs(List<NestedInteger> list) {
			for (NestedInteger item : list) {
				if (item.isInteger()) {
					queue.addLast(item.getInteger());
				} else {
					dfs(item.getList());
				}
			}
		}
	}

	interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}

