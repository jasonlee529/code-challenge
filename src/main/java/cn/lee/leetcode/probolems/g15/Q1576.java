package cn.lee.leetcode.probolems.g15;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q1576
 * @Description: https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 * @author: libo
 * @date: 2022/1/5 18:47
 * @Version: 1.0
 */
@Slf4j
public class Q1576 {

	public String modifyString(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
		for (int i = 0; i < n; ++i) {
			if (arr[i] == '?') {
				for (char ch = 'a'; ch <= 'c'; ++ch) {
					if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
						continue;
					}
					arr[i] = ch;
					break;
				}
			}
		}
		return new String(arr);
	}

	@Test
	public void test1() {
		Assert.assertEquals("azs", modifyString("?zs"));
	}

	@Test
	public void test2() {
		Assert.assertEquals("ubvaw", modifyString("ubv?w"));
	}

	@Test
	public void test3() {
		Assert.assertEquals("jaqgacb", modifyString("j?qg??b"));
	}

	@Test
	public void test4() {
		Assert.assertEquals("acywaipkja", modifyString("??yw?ipkj?"));
	}
}
