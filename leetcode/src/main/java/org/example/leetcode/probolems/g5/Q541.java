package org.example.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q541
 * @Description: https://leetcode-cn.com/problems/reverse-string-ii/
 * @author: libo
 * @date: 2021/8/20 15:51
 * @Version: 1.0
 */
@Slf4j
public class Q541 {

	public String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int start = 0;
		while (s.length() > start) {
			int end = start + k < s.length() ? start + k : s.length();
			for (int i = start; i < end; i++) {
				sb.append(s.charAt(end - i-1+start));
			}
			end = start + k + k < s.length() ? start + k + k : s.length();
			for (int i = start + k; i < end; i++) {
				sb.append(s.charAt(i));
			}
			start += k * 2;
		}
		return sb.toString();
	}

	@Test
	public void test1() {
		Assert.assertEquals("bacdfeg", reverseStr("abcdefg", 2));
	}
	@Test
	public void test2() {
		Assert.assertEquals("bacd", reverseStr("abcd", 2));
	}
}
