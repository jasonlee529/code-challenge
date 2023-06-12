package org.example.leetcode.probolems.g4;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q434
 * @Description: https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 * @author: libo
 * @date: 2021/9/13 17:36
 * @Version: 1.0
 */
@Slf4j
public class Q434 {

	@Test
	public void test1() {
		Assert.assertEquals(5, countSegments("Hello, my name is John"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(6, countSegments(", , , ,        a, eaefa"));
	}

	public int countSegments(String s) {
		if (s.length() == 0) {
			return 0;
		}
		return (int) Arrays.stream(s.split(" ")).filter(e -> !e.isEmpty()).count();
	}
}
