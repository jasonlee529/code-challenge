package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Title: Q316
 * @Description: https://leetcode-cn.com/problems/remove-duplicate-letters/
 * @author: libo
 * @date: 2020/12/20 15:29
 * @Version: 1.0
 */
@Slf4j
public class Q316 {

    @Test
    public void test1() {
        Assert.assertEquals("abc", removeDuplicateLetters("bcabc"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("acdb", removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        LinkedList<Character> deque = new LinkedList<>();
        int[] count = new int[26];
        boolean[] exists = new boolean[26];
        // 初始化
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        // 遍历s并入栈
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!exists[temp - 'a']) {
                while (!deque.isEmpty() && deque.getLast() > temp && count[deque.getLast() - 'a'] > 0) {
                    exists[deque.getLast() - 'a'] = false;
                    deque.removeLast();
                }
                deque.add(temp);
                exists[temp - 'a'] = true;
            }
            count[temp - 'a']--;
        }
        //返回
        StringBuilder res = new StringBuilder();
        for (char ch : deque) {
            res.append(ch);
        }
        return res.toString();
    }

    public String removeDuplicateLetters2(String s) {
        Map<Character, List<Integer>> pos = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = pos.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            pos.put(s.charAt(i), list);
        }
        List<Character> chars = new ArrayList<>(pos.keySet());
        List<String> res = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        dfs(chars, pos, s, 0, chars.size(), path, res);
        Collections.sort(res);
        return res.get(0);

    }

    private void dfs(List<Character> chars, Map<Character, List<Integer>> pos, String str, int begin, int end, Stack<Integer> path, List<String> res) {
        if (begin == end) {
            if (path.size() == chars.size()) {

                StringBuilder sb = new StringBuilder();
                List<Integer> list = new ArrayList<>(path);
                Collections.sort(list);
                for (int n : list) {
                    sb.append(str.charAt(n));
                }
                res.add(sb.toString());
            } else {
                return;
            }
        } else {
            for (int i = begin; i < end; i++) {
                Character ch = chars.get(i);
                List<Integer> p = pos.get(ch);
                for (int n : p) {
                    path.add(n);
                    dfs(chars, pos, str, i + 1, end, path, res);
                    path.pop();
                }
            }
        }
    }

}
