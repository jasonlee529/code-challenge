package org.example.leetcode.probolems.g0;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q68
 * @Description: https://leetcode-cn.com/problems/text-justification/
 * @author: libo
 * @date: 2021/9/9 13:53
 * @Version: 1.0
 */
@Slf4j
public class Q68 {
	@Test
	public void test1() {
		Assert.assertArrayEquals(new String[]{"This    is    an",
				"example  of text",
				"justification.  "}, fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).toArray());
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new String[]{"What   must   be",
				"acknowledgment  ",
				"shall be        "}, fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16).toArray());
	}

	@Test
	public void test3() {
		Assert.assertArrayEquals(new String[]{
						"Science  is  what we",
						"understand      well",
						"enough to explain to",
						"a  computer.  Art is",
						"everything  else  we",
						"do                  "},
				fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well",
								"enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
						20).toArray());
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		List<String> line = new ArrayList<>();
		int width = 0;
		for (int i = 0; i < words.length; i++) {
			if (maxWidth < (width + words[i].length() + line.size())) {
				//最大
				StringBuilder sb = new StringBuilder();
				String seq = "";
				for (String str : line) {
					sb.append(seq).append(str);
					seq = " ";
				}
				res.add(sb.toString());
				line = new ArrayList<>();
				line.add(words[i]);
				width = words[i].length();
				log.info(sb.toString());
			} else {
				width += words[i].length();
				line.add(words[i]);
			}
		}
		return res;
	}
}
