package cn.lee.leetcode.probolems.g4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q472
 * @Description: https://leetcode-cn.com/problems/concatenated-words/
 * @author: libo
 * @date: 2021/12/28 9:54
 * @Version: 1.0
 */
@Slf4j
public class Q472 {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Set<String> res = new LinkedHashSet<>();
		Stack<String> path = new Stack<String>();
		int[] pos = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			pos[i] = 1;
			dfs(words[i], words, pos, path, res);
			pos[i] = 0;
			path = new Stack<>();
		}
		return new ArrayList<>(res);
	}

	private void dfs(String target, String[] words, int[] pos, Stack<String> path, Set<String> res) {
		String join = join(path);
		if (target.equalsIgnoreCase(join)) {
			res.add(target);
			return;
		}
		if (join.length() >= target.length()) {
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (pos[i] == 1) {
				continue;
			}
			path.push(words[i]);
			dfs(target, words, pos, path, res);
			path.pop();
		}

	}

	private String join(Stack<String> path) {
		StringBuilder sb = new StringBuilder();
		for (String s : path) {
			sb.append(s);
		}
		return sb.toString();
	}

	@Test
	public void test1() {
		Assert.assertArrayEquals(new String[]{"catsdogcats", "dogcatsdog", "ratcatdogcat"}, findAllConcatenatedWordsInADict(
				new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}).toArray(new String[]{}));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new String[]{"catdog"}, findAllConcatenatedWordsInADict(
				new String[]{"cat", "dog", "catdog"}).toArray(new String[]{}));
	}
}
