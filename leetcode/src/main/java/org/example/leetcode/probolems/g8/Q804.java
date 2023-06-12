package org.example.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title: Q804
 * @Description: https://leetcode-cn.com/problems/unique-morse-code-words/
 * @author: libo
 * @date: 2022/4/10 0010 20:12
 * @Version: 1.0
 */
@Slf4j
public class Q804 {
    private String[] moses = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> mos = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (Character c : word.toCharArray()) {
                sb.append(moses[c - 'a']);
            }
            mos.add(sb.toString());
        }
        return mos.size();
    }

    @Test
    public void test_1() {
        Assert.assertEquals(2, uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    @Test
    public void test_2() {
        Assert.assertEquals(1, uniqueMorseRepresentations(new String[]{"a"}));
    }
}