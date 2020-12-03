package cn.lee.leetcode.probolems.g7;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Title: Q767
 * @Description: https://leetcode-cn.com/problems/reorganize-string/
 * @author: libo
 * @date: 2020/11/30 19:24
 * @Version: 1.0
 */
@Slf4j
public class Q767 {

    @Test
    public void test() {
        Assert.assertEquals("aba", reorganizeString("aab"));
    }

    public String reorganizeString(String S) {
        Map<Character, Integer> keys = new HashMap<>();
        Character c2 = null;
        Integer count = 0;
        for (Character c : S.toCharArray()) {
            keys.put(c, keys.getOrDefault(c, 0) + 1);
            if (keys.get(c2) < keys.get(c)) {
                c2 = c;
                count = keys.get(c);
            }
        }
        if (S.length() == count || count / (S.length() - count) >= 1.5) {
            return "";
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        return S;
    }
}
