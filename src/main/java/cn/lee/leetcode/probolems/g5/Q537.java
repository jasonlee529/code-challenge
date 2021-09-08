package cn.lee.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q537
 * @Description: https://leetcode-cn.com/problems/complex-number-multiplication/
 * @author: libo
 * @date: 2021/9/3 11:07
 * @Version: 1.0
 */
@Slf4j
public class Q537 {
	@Test
	public void test1() {
		Assert.assertEquals("0+2i", complexNumberMultiply("1+1i", "1+1i"));
	}

	@Test
	public void test2() {
		Assert.assertEquals("0+-2i", complexNumberMultiply("1+-1i", "1+-1i"));
	}

	public String complexNumberMultiply(String num1, String num2) {
		String[] arr1 = num1.split("\\+");
		String[] arr2 = num2.split("\\+");
		String s1 = mul(arr1[0], arr2[0]);
		String s2 = mul(arr1[1], arr2[0]);
		String s3 = mul(arr1[0], arr2[1]);
		String s4 = mul(arr1[1], arr2[1]);
		String k1 = Integer.parseInt(s1) + Integer.parseInt(s4) + "";
		String k2 = sumi(s2, s3);
		return k1 + "+" + k2;
	}

	private String sumi(String s1, String s2) {
		s1 = s1.substring(0, s1.indexOf('i'));
		s2 = s2.substring(0, s2.indexOf('i'));
		return Integer.parseInt(s1) + Integer.parseInt(s2) + "i";
	}


	private String mul(String s1, String s2) {
		boolean i1 = false;
		boolean i2 = false;
		if (s1.contains("i")) {
			s1 = s1.substring(0, s1.indexOf('i'));
			i1 = true;
		}
		if (s2.contains("i")) {
			s2 = s2.substring(0, s2.indexOf('i'));
			i2 = true;
		}
		int res = Integer.parseInt(s1) * Integer.parseInt(s2);
		String s = null;
		if (i1 && i2) {
			res = -res;
			s = String.valueOf(res);
		} else if (!i1 && !i2) {
			s = String.valueOf(res);
		} else {
			s = String.valueOf(res) + "i";
		}
		return s;
	}
}
