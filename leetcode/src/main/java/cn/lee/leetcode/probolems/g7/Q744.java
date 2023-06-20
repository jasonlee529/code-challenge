package cn.lee.leetcode.probolems.g7;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q744
 * @Description: https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * @author: libo
 * @date: 2021/12/29 13:41
 * @Version: 1.0
 */
@Slf4j
public class Q744 {
	public char nextGreatestLetter(char[] letters, char target) {
		int pos = 0;
		for (int i = 0; i < letters.length; i++) {
			if(letters[i]>target){
				pos=i;
				break;
			}
		}
		return letters[pos];
	}

	@Test
	public void test1() {
		Assert.assertEquals('c', nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
	}

	@Test
	public void test2() {
		Assert.assertEquals('f', nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
	}

	@Test
	public void test3() {
		Assert.assertEquals('f', nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
	}

	@Test
	public void test4() {
		Assert.assertEquals('c', nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
	}

	@Test
	public void test5() {
		Assert.assertEquals('j', nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
	}

	@Test
	public void test6() {
		Assert.assertEquals('c', nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
	}
}
