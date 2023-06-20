package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q402
 * @Description: https://leetcode-cn.com/problems/remove-k-digits/
 * @author: libo
 * @date: 2021/8/29 16:18
 * @Version: 1.0
 */
@Slf4j
public class Q402 {
	@Test
	public void test1() {
		Assert.assertEquals("1219", removeKdigits("1432219", 3));
	}

	@Test
	public void test2() {
		Assert.assertEquals("200", removeKdigits("10200", 1));
	}

	@Test
	public void test3() {
		Assert.assertEquals("0", removeKdigits("10", 2));
	}

	@Test
	public void test_4() {
		Assert.assertEquals("11", removeKdigits("112", 1));
	}

	@Test
	public void test_5() {
		Assert.assertEquals("112", removeKdigits("1129", 1));
	}

	@Test
	public void test_6() {
		Assert.assertEquals("12", removeKdigits("129", 1));
	}

	public String removeKdigits(String num, int k) {

		return num;
	}
}
