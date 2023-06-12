package org.example.leetcode.probolems.g10;

import java.util.Deque;
import java.util.LinkedList;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1006
 * @Description: https://leetcode-cn.com/problems/clumsy-factorial/
 * @author: libo
 * @date: 2021/4/1 9:49
 * @Version: 1.0
 */
@Slf4j
public class Q1006 {
	@Test
	public void test1() {
		Assert.assertEquals(7, clumsy(4));
	}

	@Test
	public void test2() {
		Assert.assertEquals(12, clumsy(10));
	}

	public int clumsy(int N) {
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(N);
		N--;

		int index = 0; // 用于控制乘、除、加、减
		while (N > 0) {
			if (index % 4 == 0) {
				stack.push(stack.pop() * N);
			} else if (index % 4 == 1) {
				stack.push(stack.pop() / N);
			} else if (index % 4 == 2) {
				stack.push(N);
			} else {
				stack.push(-N);
			}
			index++;
			N--;
		}

		// 把栈中所有的数字依次弹出求和
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;

	}
}
