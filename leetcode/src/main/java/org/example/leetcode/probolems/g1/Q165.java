package org.example.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q165
 * @Description: https://leetcode-cn.com/problems/compare-version-numbers/
 * @author: libo
 * @date: 2021/9/1 14:19
 * @Version: 1.0
 */
@Slf4j
public class Q165 {
	@Test
	public void test1() {
		Assert.assertEquals(0, compareVersion("1.01", "1.001"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(0, compareVersion("1.0", "1.0.0"));
	}

	@Test
	public void test3() {
		Assert.assertEquals(-1, compareVersion("0.1", "1.1"));
	}

	public int compareVersion(String version1, String version2) {
		String[] v1s = version1.split("\\.");
		String[] v2s = version2.split("\\.");
		int len = Math.max(v1s.length, v2s.length);
		for (int i = 0; i < len; i++) {
			String v1 = i >= v1s.length ? "0" : v1s[i];
			String v2 = i >= v2s.length ? "0" : v2s[i];
			Integer i1 = Integer.parseInt(v1);
			Integer i2 = Integer.parseInt(v2);
			if (i1 == i2) {
				continue;
			} else {
				return i1 - i2>0?1:-1;
			}
		}
		return 0;
	}
}
