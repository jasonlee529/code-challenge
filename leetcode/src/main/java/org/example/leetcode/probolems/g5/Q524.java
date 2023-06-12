package org.example.leetcode.probolems.g5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q524
 * @Description: https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * @author: libo
 * @date: 2021/9/14 9:24
 * @Version: 1.0
 */
@Slf4j
public class Q524 {
	@Test
	public void test1() {
		Assert.assertEquals("apple", findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
	}

	@Test
	public void test2() {
		Assert.assertEquals("a", findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
	}

	public String findLongestWord(String s, List<String> dictionary) {
		Collections.sort(dictionary, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o2.length() == o1.length()) {
					return o1.compareTo(o2);
				} else {
					return o2.length() - o1.length();
				}
			}
		});
		for (String str : dictionary) {
			if (str.length() > s.length()) {
				continue;
			}
			int i = 0, j = 0;
			while (i < s.length() && j < str.length()) {
				if (s.charAt(i) == str.charAt(j)) {
					i++;
					j++;
				} else {
					i++;
				}
			}
			if (j == str.length() ) {
				return str;
			}
		}
		return "";
	}
}
