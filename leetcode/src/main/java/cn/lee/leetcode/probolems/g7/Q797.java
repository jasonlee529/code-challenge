package cn.lee.leetcode.probolems.g7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q797
 * @Description: https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * @author: libo
 * @date: 2021/8/25 13:56
 * @Version: 1.0
 */
@Slf4j
public class Q797 {

	@Test
	public void test1() {
		List<List<Integer>> res = allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
		log.info(Arrays.toString(res.toArray()));
		Assert.assertEquals("[[0, 1, 3], [0, 2, 3]]",Arrays.toString(res.toArray()));
	}

	@Test
	public void test2() {
		List<List<Integer>> res = allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});
		log.info(Arrays.toString(res.toArray()));
		Assert.assertEquals("[[0, 4], [0, 3, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4], [0, 1, 4]]",Arrays.toString(res.toArray()));

	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		Stack<Integer> path = new Stack<>();
		path.push(0);
		dfs(graph, 0, graph.length - 1, res, path);
		return res;
	}

	private void dfs(int[][] graph, int start, int target, List<List<Integer>> res, Stack<Integer> path) {
		int[] node = graph[start];
		for (int t : node) {
			path.push(t);
			dfs(graph, t, target, res, path);
			if (t == target) {
				res.add(new ArrayList<>(path));
			}
			path.pop();
		}
	}
}
