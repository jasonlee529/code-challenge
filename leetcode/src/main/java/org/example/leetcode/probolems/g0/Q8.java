package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q8
 * @Description: https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @author: libo
 * @date: 2021/2/25 17:36
 * @Version: 1.0
 */
@Slf4j
public class Q8 {

	@Test
	public void test1() {
		Assert.assertEquals(42, myAtoi("42"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(-42, myAtoi("   -42"));
	}

	@Test
	public void test3() {
		Assert.assertEquals(4193, myAtoi("4193 with words"));
	}

	@Test
	public void test4() {
		Assert.assertEquals(987, myAtoi("words and 987"));
	}

	@Test
	public void test5() {
		Assert.assertEquals(-2147483648, myAtoi("-91283472332"));
	}

	@Test
	public void test6() {
		Assert.assertEquals(0, myAtoi(""));
	}

	@Test
	public void test7() {
		Assert.assertEquals(0, myAtoi(""));
	}

	@Test
	public void test8() {
		Assert.assertEquals(0, myAtoi(""));
	}


	public int myAtoi(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		boolean bit = true;
		String num = "";
		boolean start = true;
		for (Character c : s.toCharArray()) {
			if (c == null || c == ' ') {
				continue;
			}
			if (c == '-') {
				bit = false;
			}
			if (start && (c >= '0' && c <= '9')) {
				num += c;
			}
			if (num.length() > 0 && !(c >= '0' && c <= '9')) {
				start = false;
			}
		}
		int i = 0;
		try {
			i = Integer.parseInt(num);
		} catch (Exception e) {
			i = 2147483647;
		}
		return bit ? i : -i;
	}
}
