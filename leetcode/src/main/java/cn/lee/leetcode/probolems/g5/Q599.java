package cn.lee.leetcode.probolems.g5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q599
 * @Description: https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 * @author: libo
 * @date: 2021/9/15 13:35
 * @Version: 1.0
 */
@Slf4j
public class Q599 {

	@Test
	public void test1() {
		Assert.assertArrayEquals(new String[]{"Shogun"}, findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
				new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new String[]{"Shogun"}, findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
				new String[]{"KFC", "Shogun", "Burger King"}));
	}

	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<Integer, List<String>> ans = new HashMap<>();
		int min = list1.length + list2.length;
		for (int i = 0; i < list1.length; i++) {
			for (int j = 0; j < list2.length; j++) {
				if (list1[i].equals(list2[j])) {
					int sum = i + j;
					min = min < sum ? min : sum;
					List<String> tmp = ans.getOrDefault(sum, new ArrayList<>());
					tmp.add(list1[i]);
					ans.put(sum, tmp);
				}
			}
		}
		return ans.get(min).toArray(new String[]{});
	}
}
