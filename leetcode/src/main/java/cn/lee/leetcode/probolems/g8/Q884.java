package cn.lee.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Title: Q884
 * @Description: https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 * @author: libo
 * @date: 2020/9/23 23:14
 * @Version: 1.0
 */
@Slf4j
public class Q884 {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> keys = new HashMap<>();
        for (String k : A.split(" ")) {
            keys.put(k, keys.getOrDefault(k, 0) + 1);
        }
        for (String k : B.split(" ")) {
            keys.put(k, keys.getOrDefault(k, 0) + 1);
        }
        List<String> ans = new LinkedList();
        for (String word : keys.keySet()) {
            if (keys.get(word) == 1) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
