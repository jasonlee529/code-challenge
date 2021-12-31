package cn.lee.leetcode.probolems.g5;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q526
 * @Description: https://leetcode-cn.com/problems/beautiful-arrangement/
 * @author: libo
 * @date: 2021/12/31 9:55
 * @Version: 1.0
 */
@Slf4j
public class Q526 {
	@Test
	public void test1() {
		Assert.assertEquals(2, countArrangement(2));
	}

	@Test
	public void test2() {
		Assert.assertEquals(1, countArrangement(1));
	}


	List<Integer>[] match;
	boolean[] vis;
	int num;

	public int countArrangement(int n) {
		vis = new boolean[n + 1];
		match = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			match[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i % j == 0 || j % i == 0) {
					match[i].add(j);
				}
			}
		}
		backtrack(1, n);
		return num;
	}

	public void backtrack(int index, int n) {
		if (index == n + 1) {
			num++;
			return;
		}
		for (int x : match[index]) {
			if (!vis[x]) {
				vis[x] = true;
				backtrack(index + 1, n);
				vis[x] = false;
			}
		}
	}
}