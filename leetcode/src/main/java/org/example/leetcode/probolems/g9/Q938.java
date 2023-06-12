package org.example.leetcode.probolems.g9;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q938
 * @Description: https://leetcode-cn.com/problems/range-sum-of-bst/
 * @author: libo
 * @date: 2021/4/27 11:23
 * @Version: 1.0
 */
@Slf4j
public class Q938 {

	@Test
	public void test1() {
		Assert.assertEquals(32, rangeSumBST(TreeNodeFactory.build(new Integer[]{10, 5, 15, 3, 7, null, 18}), 7, 15));
	}

	@Test
	public void test2() {
		Assert.assertEquals(23, rangeSumBST(TreeNodeFactory.build(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6}), 6, 10));
	}

	public int rangeSumBST(TreeNode root, int low, int high) {
		int sum = 0;

		return sum;
	}
}
