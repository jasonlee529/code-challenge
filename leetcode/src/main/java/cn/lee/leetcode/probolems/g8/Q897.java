package cn.lee.leetcode.probolems.g8;

import java.util.ArrayList;
import java.util.List;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q897
 * @Description: https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @author: libo
 * @date: 2021/4/25 14:38
 * @Version: 1.0
 */
@Slf4j
public class Q897 {
	@Test
	public void test1() {
		Assert.assertEquals(TreeNodeFactory.build(new Integer[]{1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9}).toString(), increasingBST(
				TreeNodeFactory.build(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9})
		).toString());
	}

	@Test
	public void test2() {
		Assert.assertEquals(TreeNodeFactory.build(new Integer[]{1, null, 5, null, 7}).toString(), increasingBST(
				TreeNodeFactory.build(new Integer[]{5, 1, 7})
		).toString());
	}

	public TreeNode increasingBST(TreeNode root) {
		List<Integer> nodes = new ArrayList<>();
		inorder(root, nodes);
		TreeNode dummyNode = new TreeNode(-1);
		TreeNode currNode = dummyNode;
		for (int value : nodes) {
			currNode.right = new TreeNode(value);
			currNode = currNode.right;
		}
		return dummyNode.right;
	}

	private void inorder(TreeNode node, List<Integer> nodes) {
		if (node == null) {
			return;
		}
		inorder(node.left, nodes);
		nodes.add(node.val);
		inorder(node.right, nodes);
	}
}
