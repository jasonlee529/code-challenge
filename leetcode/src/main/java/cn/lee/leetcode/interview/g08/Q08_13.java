package cn.lee.leetcode.interview.g08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q08_13
 * @Description: https://leetcode-cn.com/problems/pile-box-lcci/
 * @author: libo
 * @date: 2021/12/29 16:56
 * @Version: 1.0
 */
@Slf4j
public class Q08_13 {

	public int pileBox(int[][] box) {
		Arrays.sort(box, (a, b) -> {
			return a[0] == b[0] ? (a[1] == a[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0];
		});
		Stack<int[]> path = new Stack<>();
		List<Integer> res = new ArrayList<>();
		res.add(0);
		dfs(box, 0, path, res);
		return res.get(0);
	}

	private void dfs(int[][] box, int start, Stack<int[]> path, List<Integer> res) {
		if (start >= box.length) {
			if (res.get(0) < getHeight(path)) {
				res.add(0, getHeight(path));
			}
		}
		for (int i = start; i < box.length; i++) {
			if (path.isEmpty()) {
				path.push(box[i]);
			} else {
				int[] a = path.pop();
				int[] b = box[i];
				if (b[0] > a[0] && b[1] > a[1] && b[2] > a[2]) {
					path.push(a);
					path.push(b);
				} else {
					path.push(a);
				}
			}
			dfs(box, i + 1, path, res);
			if (!path.isEmpty()) {
				path.pop();
			}
		}
	}

	private Integer getHeight(Stack<int[]> path) {
		int res=0;
		for(int[]a:path){
			res+=a[2];
		}
		return res;
	}

	@Test
	public void test1() {
		Assert.assertEquals(6, pileBox(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(10, pileBox(new int[][]{{1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}}));
	}
}
