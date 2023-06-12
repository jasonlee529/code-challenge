package org.example.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: Q500
 * @Description: https://leetcode-cn.com/problems/keyboard-row/
 * @author: libo
 * @date: 2020/10/10 16:58
 * @Version: 1.0
 */
@Slf4j
public class Q500 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q500().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }

    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String w : words) {
            List<Character> line = first(w);
            boolean istrue = true;
            for (char c : w.toCharArray()) {
                istrue &= line.contains(c);
            }
            if (istrue) {
                res.add(w);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    private List<Character> first(String w) {
        List<Character> line1 = Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        List<Character> line2 = Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        List<Character> line3 = Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M', 'z', 'x', 'c', 'v', 'b', 'n', 'm');
        if (line1.contains(w.charAt(0))) {
            return line1;
        }
        if (line2.contains(w.charAt(0))) {
            return line2;
        }
        if (line3.contains(w.charAt(0))) {
            return line3;
        }
        return null;
    }
}
