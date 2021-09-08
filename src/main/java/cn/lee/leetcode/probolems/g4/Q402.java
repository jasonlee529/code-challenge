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

	public String removeKdigits(String num, int k) {
		if (k >= num.length()) {
			return "0";
		}
		while (k > 0 || (num.length() > 0 && num.charAt(0) == '0')) {
			if (num.charAt(0) == '0') {
				num = num.substring(1);
				continue;
			}
			if (num.charAt(0) < num.charAt(1)) {
				num = num.charAt(0) + num.substring(2);
			} else {
				num = num.substring(1);
			}
			k--;
//			log.info("{},{}", num, k);
		}
		if(num.length()==0){
			return "0";
		}
		return num;
	}
}
