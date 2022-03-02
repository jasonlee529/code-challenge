package cn.lee.leetcode.probolems.g7;

import java.util.Comparator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q726
 * @Description: https://leetcode-cn.com/problems/number-of-atoms/
 * @author: libo
 * @date: 2022/2/25 17:19
 * @Version: 1.0
 */
@Slf4j
public class Q726 {

	public String countOfAtoms(String formula) {
		Map<String, Integer> data = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		Stack<String> stack = new Stack<>();

		
		StringBuilder sb = new StringBuilder();
		for (String key : data.keySet()) {
			sb.append(key).append(data.get(key));
		}
		return sb.toString();
	}

	@Test
	public void test_1() {
		Assert.assertEquals("H2O", countOfAtoms("H20"));
	}

	@Test
	public void test_2() {
		Assert.assertEquals("H2MgO2", countOfAtoms("Mg(OH)2"));
	}

	@Test
	public void test_3() {
		Assert.assertEquals("K4N2O14S4", countOfAtoms("K4(ON(SO3)2)2"));
	}
}
