package cn.lee.leetcode.probolems.g12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1220
 * @Description: https://leetcode-cn.com/problems/count-vowels-permutation/
 * @author: libo
 * @date: 2022/1/17 9:59
 * @Version: 1.0
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 */
@Slf4j
public class Q1220 {

	public int countVowelPermutation(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		Stack<Character> path = new Stack<>();
		dfs(n, path, res);
		return res.get(0);
	}

	private void dfs(int n, Stack<Character> path, List<Integer> res) {
		if (n <= 0) {
			res.add(0, (res.get(0) + 1) % 1000000007);
			return;
		}
		Character c = '0';
		if (!path.empty()) {
			c = path.peek();
		}
		switch (c) {
			case 'a':
				path.push('e');
				dfs(n - 1, path, res);
				path.pop();
				break;
			case 'e':
				path.push('a');
				dfs(n - 1, path, res);
				path.pop();
				path.push('i');
				dfs(n - 1, path, res);
				path.pop();
				break;
			case 'i':
				path.push('a');
				dfs(n - 1, path, res);
				path.pop();
				path.push('e');
				dfs(n - 1, path, res);
				path.pop();
				path.push('o');
				dfs(n - 1, path, res);
				path.pop();
				path.push('u');
				dfs(n - 1, path, res);
				path.pop();
				break;
			case 'o':
				path.push('i');
				dfs(n - 1, path, res);
				path.pop();
				path.push('u');
				dfs(n - 1, path, res);
				path.pop();
				break;
			case 'u':
				path.push('a');
				dfs(n - 1, path, res);
				path.pop();
				break;
			case '0':
				path.push('a');
				dfs(n - 1, path, res);
				path.pop();
				path.push('e');
				dfs(n - 1, path, res);
				path.pop();
				path.push('i');
				dfs(n - 1, path, res);
				path.pop();
				path.push('o');
				dfs(n - 1, path, res);
				path.pop();
				path.push('u');
				dfs(n - 1, path, res);
				path.pop();
				break;
		}
	}


	@Test
	public void test_1() {
		Assert.assertEquals(5, countVowelPermutation(1));
	}

	@Test
	public void test_2() {
		Assert.assertEquals(10, countVowelPermutation(2));
	}

	@Test
	public void test_3() {
		Assert.assertEquals(68, countVowelPermutation(5));
	}
}
