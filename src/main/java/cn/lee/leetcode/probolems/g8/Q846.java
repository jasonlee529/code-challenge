package cn.lee.leetcode.probolems.g8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q846
 * @Description: https://leetcode-cn.com/problems/hand-of-straights/
 * @author: libo
 * @date: 2021/12/30 10:16
 * @Version: 1.0
 */
@Slf4j
public class Q846 {

	public boolean isNStraightHand(int[] hand, int groupSize) {
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
		for (int i : hand) {
			map.put(i, map.getOrDefault(i, 0) + 1);
			q.add(i);
		}
		while (!q.isEmpty()) {
			int t = q.poll();
			if (map.get(t) == 0) continue;
			for (int i = 0; i < groupSize; i++) {
				int cnt = map.getOrDefault(t + i, 0);
				if (cnt == 0) return false;
				map.put(t + i, cnt - 1);
			}
		}
		return true;
	}

	@Test
	public void test1() {
		Assert.assertEquals(true, isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
	}

	@Test
	public void test3() {
		Assert.assertEquals(true, isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 2));
	}
}
