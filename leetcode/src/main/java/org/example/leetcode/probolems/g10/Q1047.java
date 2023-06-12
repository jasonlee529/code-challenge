package org.example.leetcode.probolems.g10;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1047
 * @Description: https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * @author: libo
 * @date: 2021/3/9 10:33
 * @Version: 1.0
 */
@Slf4j
public class Q1047 {
	@Test
	public void test1() {
		Assert.assertEquals("ca", removeDuplicates("abbaca"));
	}

	public String removeDuplicates(String S) {
		int index = 0;
		while (index < S.length() - 1) {
			if (S.charAt(index) == S.charAt(index + 1)) {
				String s1 = S.substring(0, index);
				String s2 = S.substring(index + 2);
				S = s1 + s2;
				index = 0;
			} else {
				index++;
			}
		}
		return S;
	}
}
