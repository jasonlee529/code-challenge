package cn.lee.leetcode.probolems.g11;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q1184
 * @Description: https://leetcode-cn.com/problems/distance-between-bus-stops/
 * @author: libo
 * @date: 2022/2/15 15:23
 * @Version: 1.0
 */
@Slf4j
public class Q1184 {

	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int a = 0, b = 0;
		if (start > destination) {
			int t = start;
			start = destination;
			destination = t;
		}
		for (int i = 0; i < start; i++) {
			a += distance[i];
		}
		for (int i = start; i < destination; i++) {
			b += distance[i];
		}
		for (int i = destination; i < distance.length; i++) {
			a += distance[i];
		}
		return Math.min(a, b);
	}

	@Test
	public void test_1() {
		Assert.assertEquals(1, distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
	}

	@Test
	public void test_2() {
		Assert.assertEquals(3, distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));
	}

	@Test
	public void test_3() {
		Assert.assertEquals(4, distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
	}
}
