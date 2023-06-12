package org.example.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q171
 * @Description: https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @author: libo
 * @date: 2020/9/16 9:05
 * @Version: 1.0
 */
@Slf4j
public class Q171 {
    public static void main(String[] args) {
        System.out.println(new Q171().titleToNumber("DU"));
    }
    public int titleToNumber(String s) {
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int base = cases(c);
            sum=sum*26+base;
        }
        return sum;
    }

    private int cases(char c) {
        return (c - 'A') + 1;
    }
}
