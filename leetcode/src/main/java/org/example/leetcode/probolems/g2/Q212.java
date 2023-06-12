package org.example.leetcode.probolems.g2;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q212
 * @Description: https://leetcode-cn.com/problems/word-search-ii/
 * @author: libo
 * @date: 2021/9/16 18:07
 * @Version: 1.0
 */
@Slf4j
public class Q212 {
	@Test
	public void test1() {
		Assert.assertArrayEquals(new String[]{"eat", "oath"}, findWords(new char[][]{{'o', 'a', 'a', 'n'}, {
						'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}
				, new String[]{"oath", "pea", "eat", "rain"}).toArray());
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new String[]{}, findWords(new char[][]{{'a', 'b'}, {
						'c', 'd'}}
				, new String[]{"abcb"}).toArray());
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		int rows = board.length, cols = board[0].length;
		for (String word : words) {
			for (Character c : word.toCharArray()) {
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						if (c == board[i][j]) {
							int[][] pos = new int[rows][cols];
							if (test(board, pos, i, j, word, 0)) {
								res.add(word);
							}
						}
					}
				}
			}
		}
		return res;
	}

	private boolean test(char[][] board, int[][] pos, int i, int j, String word, int index) {
		if (board[i][j] == word.charAt(index)) {
			pos[i][j] = 0;
		}
		if (word.length() - 1 == index) {
			return true;
		}
		if(i==0){

		}
		return false;
	}
}
