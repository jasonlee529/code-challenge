package cn.lee.leetcode.probolems.g0;

import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q71
 * @Description: https://leetcode-cn.com/problems/simplify-path/
 * @author: libo
 * @date: 2022/1/6 15:58
 * @Version: 1.0
 */
@Slf4j
public class Q71 {

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		if (path.startsWith("/")) {
			for (String key : path.split("/")) {
				if (key.equalsIgnoreCase("")) {
					continue;
				} else if (key.equalsIgnoreCase(".")) {
					continue;
				} else if (key.equalsIgnoreCase("/")) {
					continue;
				} else if (key.equalsIgnoreCase("..")) {
					if (stack.size() > 0) {
						stack.pop();
					}
				} else {
					stack.push(key);
				}
			}
		} else {
			return "";
		}
		StringBuilder sb = new StringBuilder("/");
		String seq = "";
		for (String key : stack) {
			sb.append(seq).append(key);
			seq = "/";
		}
		return sb.toString();
	}

	@Test
	public void test1() {
		Assert.assertEquals("/home", simplifyPath("/home/"));
	}

	@Test
	public void test2() {
		Assert.assertEquals("/", simplifyPath("/../"));
	}

	@Test
	public void test3() {
		Assert.assertEquals("/home/foo", simplifyPath("/home//foo/"));
	}

	@Test
	public void test4() {
		Assert.assertEquals("/c", simplifyPath("/a/./b/../../c/"));
	}
}
