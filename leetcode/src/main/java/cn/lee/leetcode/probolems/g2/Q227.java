package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q227
 * @Description: https://leetcode-cn.com/problems/basic-calculator-ii/
 * @author: libo
 * @date: 2021/3/11 9:34
 * @Version: 1.0
 */
@Slf4j
public class Q227 {

	@Test
	public void test1() {
		Assert.assertEquals(7, calculate("3+2*2"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(1, calculate(" 3/2 "));
	}

	@Test
	public void test3() {
		Assert.assertEquals(5, calculate(" 3+5 / 2 "));
	}

	public int calculate(String s) {


		return 0;
	}
}
