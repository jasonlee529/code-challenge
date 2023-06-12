package org.example.leetcode.probolems.g8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q881
 * @Description: https://leetcode-cn.com/problems/boats-to-save-people/
 * @author: libo
 * @date: 2021/8/26 19:30
 * @Version: 1.0
 */
@Slf4j
public class Q881 {
	@Test
	public void test1() {
		Assert.assertEquals(1, numRescueBoats(new int[]{1, 2}, 3));
	}

	@Test
	public void test2() {
		Assert.assertEquals(3, numRescueBoats(new int[]{3, 2, 2, 1}, 3));
	}

	@Test
	public void test3() {
		Assert.assertEquals(4, numRescueBoats(new int[]{3, 5, 3, 4}, 5));
	}

	@Test
	public void test4() {
		Assert.assertEquals(2, numRescueBoats(new int[]{5, 1, 4, 2}, 6));
	}

	public int numRescueBoats(int[] people, int limit) {
		int ans = 0;
		Arrays.sort(people);
		int light = 0, heavy = people.length - 1;
		while (light <= heavy) {
			if (people[light] + people[heavy] <= limit) {
				++light;
			}
			--heavy;
			++ans;
		}
		return ans;
	}

	public int numRescueBoats2(int[] people, int limit) {
		int cnt = 0;
		List<Integer> peoples = Arrays.stream(people).boxed().sorted(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.intValue() - o1.intValue();
			}
		}).collect(Collectors.toList());
		while (peoples.size() > 0) {
			int t1 = findMax(peoples, limit);
			if (t1 > 0) {
				peoples.remove(Integer.valueOf(t1));
			}
			int t2 = findMax(peoples, limit - t1);
			if (t2 > 0) {
				peoples.remove(Integer.valueOf(t2));
			}
			cnt++;
		}
		return cnt;
	}

	private int findMax(List<Integer> peoples, int target) {
		if (peoples.isEmpty()) {
			return 0;
		}

		for (int n : peoples) {
			if (n <= target) {
				return n;
			}
		}
		return 0;
	}
}
