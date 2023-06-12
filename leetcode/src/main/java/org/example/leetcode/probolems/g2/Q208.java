package org.example.leetcode.probolems.g2;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q208
 * @Description: https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @author: libo
 * @date: 2021/4/14 13:37
 * @Version: 1.0
 */
@Slf4j
public class Q208 {
	@Test
	public void test1() {
		Trie trie = new Trie();
		trie.insert("apple");
		Assert.assertTrue(trie.search("apple"));   // 返回 True
		Assert.assertFalse(trie.search("app"));     // 返回 False
		Assert.assertTrue(trie.startsWith("app")); // 返回 True
		trie.insert("app");
		Assert.assertTrue(trie.search("app"));// 返回 True

	}

	class Trie {
		Map<String, String> maps;

		/**
		 * Initialize your data structure here.
		 */
		public Trie() {
			maps = new HashMap<>();
		}

		/**
		 * Inserts a word into the trie.
		 */
		public void insert(String word) {
			maps.put(word, word);
		}

		/**
		 * Returns if the word is in the trie.
		 */
		public boolean search(String word) {
			return maps.containsKey(word);
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			boolean isSuc = false;
			for (String key : maps.keySet()) {
				if (key.startsWith(prefix)) {
					return true;
				}
			}
			return isSuc;
		}
	}
}

