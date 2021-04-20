package cn.lee.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Title: HashMapTests
 * @Description:
 * @author: libo
 * @date: 2021/4/19 11:33
 * @Version: 1.0
 */
@Slf4j
public class HashMapTests {

	@Test
	public void test() {
		for (int i = 0; i < 100; i++) {
			System.out.println(String.format("%d ==> %d", i, tableSizeFor(i)));
			int n = i - 1;
			System.out.println(String.format("i= %d ==> n= %d, %s", i, n, Integer.toBinaryString(n)));
			n |= n >>> 1;
			System.out.println(String.format("i= %d ==> n= %d, %s", i, n, Integer.toBinaryString(n)));
			n |= n >>> 2;
			System.out.println(String.format("i= %d ==> n= %d, %s", i, n, Integer.toBinaryString(n)));
			n |= n >>> 4;
			System.out.println(String.format("i= %d ==> n= %d, %s", i, n, Integer.toBinaryString(n)));
			n |= n >>> 8;
			System.out.println(String.format("i= %d ==> n= %d, %s", i, n, Integer.toBinaryString(n)));
			n |= n >>> 16;
			System.out.println(String.format("i= %d ==> n= %d, %s", i, n, Integer.toBinaryString(n)));
		}
	}

	@Test
	public void test2() {
		for (int i = 0; i < 100; i++) {
			System.out.println(String.format("i= %d ==> n= %s, %s", i, Integer.toBinaryString(i), Integer.toBinaryString(i>>>1)));
		}
	}

	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return n;
	}

	String to2(int n) {

		return "";
	}
}
