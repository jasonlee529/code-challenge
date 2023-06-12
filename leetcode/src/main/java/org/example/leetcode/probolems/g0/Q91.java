package org.example.leetcode.probolems.g0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q91
 * @Description: https://leetcode-cn.com/problems/decode-ways/
 * @author: libo
 * @date: 2021/4/21 9:18
 * @Version: 1.0
 */
@Slf4j
public class Q91 {

	@Test
	public void test1() {
		Assert.assertEquals(2, numDecodings("12"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(3, numDecodings("226"));
	}

	@Test
	public void test3() {
		Assert.assertEquals(0, numDecodings("0"));
	}

	@Test
	public void test4() {
		Assert.assertEquals(1, numDecodings("27"));
	}

	public int numDecodings(String s) {
		List<List<String>> res = new ArrayList<>();
		Stack<String> path = new Stack<>();
		dfs(s, 0, path, res);
		return res.size();
	}

	private void dfs(String s, int begin, Stack<String> path, List<List<String>> res) {
		if (begin >= s.length()) {
			res.add(new ArrayList(path));
			return;
		}
		if (s.charAt(begin) == '0') {
			return;
		}
		String s1 = s.substring(begin, begin + 1);
		path.add(s1);
		dfs(s, begin + 1, path, res);
		path.pop();
		if (begin + 2 <= s.length()) {
			s1 = s.substring(begin, begin + 2);
			if (Integer.parseInt(s1) > 26) {
				return;
			}
			path.add(s1);
			dfs(s, begin + 2, path, res);
			path.pop();
		}
		return;
	}
}
