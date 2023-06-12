package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Title: Q31
 * @Description: https://leetcode-cn.com/problems/next-permutation/
 * @author: libo
 * @date: 2020/11/10 12:31
 * @Version: 1.0
 */
@Slf4j
public class Q31 {
	@Test
	public void test_1() {
		Assert.assertArrayEquals(new int[]{1, 3, 2}, nextPermutation(new int[]{1, 2, 3}));
	}

	@Test
	public void test_2() {
		Assert.assertArrayEquals(new int[]{1, 2, 3}, nextPermutation(new int[]{3, 2, 1}));
	}

	@Test
	public void test_3() {
		Assert.assertArrayEquals(new int[]{2, 1, 3}, nextPermutation(new int[]{1, 3, 2}));
	}

	@Test
	public void test_4() {
		Assert.assertArrayEquals(new int[]{4, 2, 0, 3, 0, 2, 2}, nextPermutation(new int[]{4, 2, 0, 2, 3, 2, 0}));
	}

	public int[] nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
		return nums;
	}


	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void reverse(int[] nums, int start) {
		int left = start, right = nums.length - 1;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	@Test
	public void test_5() {
		int[] nums = new int[]{2, 3, 1};
		Arrays.sort(nums, 0, 3);
		System.out.println(Arrays.toString(nums));
		nums = new int[]{2, 3, 1};
		Arrays.sort(nums, 1, 3);
		System.out.println(Arrays.toString(nums));
		nums = new int[]{2, 3, 1};
	}

	public int[] nextPermutation2(int[] nums) {
		int left = nums.length - 2, right = nums.length - 1;
		boolean is = true;
		for (int i = left; i >= 0; i--) {
			if (nums[i] <= nums[i + 1]) {
				is = false;
				left = i;
				right = i + 1;
				break;
			}
		}
		System.out.println(left + " " + right);
		System.out.println(Arrays.toString(nums));
		if (left >= 0) {
			int t = nums[left];
			nums[left] = nums[right];
			nums[right] = t;
		}
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums, left, nums.length);
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
