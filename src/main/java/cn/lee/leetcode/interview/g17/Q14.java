package cn.lee.leetcode.interview.g17;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q14
 * @Description: https://leetcode-cn.com/problems/smallest-k-lcci/
 * @author: libo
 * @date: 2021/9/3 10:41
 * @Version: 1.0
 */
@Slf4j
public class Q14 {
	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4));
	}

	public int[] smallestK(int[] arr, int k) {
		int[] res = new int[k];
		Arrays.sort(arr);
		for (int i = 0; i < k; i++) {
			res[i] = arr[i];
		}
		return res;
	}
}
