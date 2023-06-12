package org.example.leetcode.probolems.g11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1178
 * @Description: https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
 * @author: libo
 * @date: 2021/2/26 10:04
 * @Version: 1.0
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 */
@Slf4j
public class Q1178 {

	@Test
	public void test1() {
		Assert.assertArrayEquals(new Integer[]{1, 1, 3, 2, 4, 0}, findNumOfValidWords(new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"}, new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}).toArray());
	}

	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		// 转用 「哈希表」来统计出所有的 word 所对应的二进制数值
		Map<Integer, Integer> map = new HashMap<>();
		for (String w : words) {
			int t = getBin(w);
			map.put(t, map.getOrDefault(t, 0) + 1);
		}
		// 判定每个 puzzles 有多少个谜底
		List<Integer> ans = new ArrayList<>();
		for (String p : puzzles) ans.add(getCnt(map, p));
		return ans;
	}

	int getCnt(Map<Integer, Integer> map, String str) {
		int ans = 0;
		int m = str.length();
		char[] cs = str.toCharArray();
		// 当前 puzzles 的首个字符在二进制数值中的位置
		int first = cs[0] - 'a';
		// 枚举「除首个字母」以外的所有组合
		for (int i = 0; i < (1 << (m - 1)); i++) {
			// 先将首字母提取出来
			int u = 1 << first;
			// 枚举「除首个字母」之后的每一位，结合上面的首个字母
			// 其实就是枚举以 str 首字母开头的字符有多少种
			for (int j = 1; j < m; j++) {
				if (((i >> (j - 1)) & 1) != 0) u += 1 << (cs[j] - 'a');
			}
			// 查询这样的字符是否出现在 `words` 中，出现了多少次
			if (map.containsKey(u)) ans += map.get(u);
		}
		return ans;
	}

	// 将 str 所包含的字母用二进制标识
	// 如果 str = abz 则对应的二进制为 100...011 (共 26 位，从右往左是 a - z)
	int getBin(String str) {
		int t = 0;
		char[] cs = str.toCharArray();
		for (char c : cs) {
			// 每一位字符所对应二进制数字中哪一位
			int u = c - 'a';
			// 如果当前位置为 0，代表还没记录过，则进行记录 (不重复记录)
			if ((t >> u & 1) == 0) t += 1 << u;
		}
		return t;
	}

	public List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
		List<Integer> res = new ArrayList<>();
		for (String puzzle : puzzles) {
			int cnt = 0;
			for (String w : words) {
				if (judge(puzzle, w)) {
					cnt++;
				}
			}
			res.add(cnt);
		}
		return res;
	}

	private boolean judge(String puzzle, String word) {
		boolean ans = true;
		ans = ans & word.indexOf(puzzle.charAt(0)) >= 0;
		for (Character character : word.toCharArray()) {
			ans = ans & puzzle.indexOf(character) >= 0;
		}
		return ans;
	}
}
