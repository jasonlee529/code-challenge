package cn.lee.leetcode.probolems.g1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q115
 * @Description: https://leetcode-cn.com/problems/distinct-subsequences/
 * @author: libo
 * @date: 2021/3/17 9:18
 * @Version: 1.0
 */
@Slf4j
public class Q115 {

	@Test
	public void test1() {
		Assert.assertEquals(3, numDistinct("rabbbit", "rabbit"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(5, numDistinct("babgbag", "bag"));
	}

	public int numDistinct(String s, String t) {
		List<String> res = new ArrayList<>();
		Deque<Character> path = new LinkedList<>();
		dfs(s, t, 0, path, res);
		return res.size();
	}

	private void dfs(String s, String t, int begin, Deque<Character> path, List<String> res) {
		if (path.size() > t.length()) {
			return;
		}
		if (isMatch(path, t)) {
			if (path.size() == t.length()) {
				res.add(t);
				return;
			}
			for (int i = begin; i < s.length(); i++) {
				path.add(s.charAt(i));
				dfs(s, t, i + 1, path, res);
				path.removeLast();
			}
		} else {
			return;
		}
	}

	private boolean isMatch(Deque<Character> path, String t) {
		List<Character> tmp = new ArrayList<>(path);
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i) != t.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
