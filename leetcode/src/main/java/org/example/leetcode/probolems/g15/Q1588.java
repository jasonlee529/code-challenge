package org.example.leetcode.probolems.g15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q1588
 * @Description: https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 * @author: libo
 * @date: 2021/8/29 15:51
 * @Version: 1.0
 */
@Slf4j
public class Q1588 {

	@Test
	public void test1() {
		Assert.assertEquals(58, sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(3, sumOddLengthSubarrays(new int[]{1, 2}));
	}

	@Test
	public void test3() {
		Assert.assertEquals(66, sumOddLengthSubarrays(new int[]{10, 11, 12}));
	}

	public int sumOddLengthSubarrays(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i+=2){
			for(int j=0;i+j<arr.length;j++){
				for(int m=j;m<=i+j;m++){
					sum+=arr[m];
				}
			}
		}
		return sum;
	}
}
