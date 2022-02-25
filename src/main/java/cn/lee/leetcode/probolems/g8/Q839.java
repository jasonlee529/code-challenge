package cn.lee.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q839
 * @Description: https://leetcode-cn.com/problems/similar-string-groups/
 * @author: libo
 * @date: 2022/2/18 11:47
 * @Version: 1.0
 */
@Slf4j
public class Q839 {

	public int numSimilarGroups(String[] strs) {
		int res = 0;
		for (int i = 0; i < strs.length; i++) {
			for (int j = i + 1; j < strs.length; j++) {
				if (sim(strs[i], strs[j])) {
					res++;
				}
			}
		}
		return res;
	}

	private boolean sim(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				diff++;
			}
		}
		return diff == 2;
	}

	@Test
	public void test_1() {
		Assert.assertEquals(2, numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
	}

	@Test
	public void test_2() {
		Assert.assertEquals(1, numSimilarGroups(new String[]{"omv", "ovm"}));
	}
	@Test
	public void test_3() {
		Assert.assertEquals(1, numSimilarGroups(new String[]{"blw","bwl","wlb"}));
	}
}
