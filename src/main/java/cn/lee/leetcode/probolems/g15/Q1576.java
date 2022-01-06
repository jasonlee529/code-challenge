package cn.lee.leetcode.probolems.g15;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q1576
 * @Description: https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 * @author: libo
 * @date: 2022/1/5 18:47
 * @Version: 1.0
 */
@Slf4j
public class Q1576 {
	char[]arr=new char[26];
	public String modifyString(String s) {
		for(int i=0;i<26;i++){
			arr[i]=(char)('a'+i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '?') {
				sb.append(find(s, i));
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	private char find(String s, int i) {
		if (i == 0 && i == s.length() - 1) {
			return 'a';
		} else if (i == 0) {
			return  arr[s.charAt(i+1)+1%26];
		}else if(i==s.length()-1){
			return arr[s.charAt(i-1)+1%26];
		}else{
			return arr[s.charAt(i-1)+1%26];
		}
	}

	@Test
	public void test1() {
		Assert.assertEquals("azs", modifyString("?zs"));
	}

	@Test
	public void test2() {
		Assert.assertEquals("ubvaw", modifyString("ubv?w"));
	}

	@Test
	public void test3() {
		Assert.assertEquals("jaqgacb", modifyString("j?qg??b"));
	}

	@Test
	public void test4() {
		Assert.assertEquals("acywaipkja", modifyString("??yw?ipkj?"));
	}
}
