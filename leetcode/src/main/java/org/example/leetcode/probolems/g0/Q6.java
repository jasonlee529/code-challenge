package org.example.leetcode.probolems.g0;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q6
 * @Description:
 * @author: libo
 * @date: 2021/2/25 10:15
 * @Version: 1.0
 */
@Slf4j
public class Q6 {

	@Test
	public void test1() {
		Assert.assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
	}

	@Test
	public void test2() {
		Assert.assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));
	}

	@Test
	public void test3() {
		Assert.assertEquals("A", convert("A", 1));
	}

	@Test
	public void test4() {
		Assert.assertEquals("AB", convert("AB", 1));
	}

	@Test
	public void test5() {
		Assert.assertEquals("ABC", convert("ABC", 1));
	}

	@Test
	public void test6() {
		Assert.assertEquals("ACBD", convert("ABCD", 2));
	}
	public String convert(String s, int numRows) {
		if(numRows < 2) return s;
		List<StringBuilder> rows = new ArrayList<StringBuilder>();
		for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
		int i = 0, flag = -1;
		for(char c : s.toCharArray()) {
			rows.get(i).append(c);
			if(i == 0 || i == numRows -1) flag = - flag;
			i += flag;
		}
		StringBuilder res = new StringBuilder();
		for(StringBuilder row : rows) res.append(row);
		return res.toString();
	}
	public String convert2(String s, int numRows) {
		Character[][] res = new Character[numRows][s.length()];
		int row = 0, col = 0;
		boolean z = false;
		for (int j = 0; j < s.length(); j++) {
			System.out.println(String.format("%d,%d,%d", j, row, col));
			res[row][col] = s.charAt(j);
			if (z) {
				row--;
				col++;
				if (row <= 0) {
					z = false;
					row = 0;
				}
			} else {
				row++;
			}
			if (row == numRows) {
				z = true;
				col++;
				row = row - 2 > 0 ? row - 2 : 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character[] r : res) {
			for (Character c : r) {
				if (c == null) continue;
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
		return sb.toString().trim();
	}
}
