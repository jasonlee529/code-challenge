package org.example.leetcode.probolems.g9;

import java.util.*;

import lombok.extern.slf4j.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * @Title: Q978
 * @Description: https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * @author: libo
 * @date: 2021/2/8 14:50
 * @Version: 1.0
 */
@Slf4j
public class Q978 {
	@Test
	public void test1() {
		assertEquals(5, maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
	}

	@Test
	public void test2() {
		assertEquals(2, maxTurbulenceSize(new int[]{4, 8, 12, 16}));
	}

	public int maxTurbulenceSize(int[] arr) {
		String str = "";
		List<String> arr2 = new ArrayList();
		Map<String, String> map = new HashMap();

		return 0;
	}

}
