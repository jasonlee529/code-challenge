package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q482
 * @Description: https://leetcode-cn.com/problems/license-key-formatting/
 * @author: libo
 * @date: 2020/9/30 17:04
 * @Version: 1.0
 */
@Slf4j
public class Q482 {
    public static void main(String[] args) {
//        System.out.println(new Q482().licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(new Q482().licenseKeyFormatting("2-5g-3-J", 2));
    }

    /**
     * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。
     * 特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。
     * 两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
     *
     * @param S
     * @param K
     * @return
     */
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int index = S.length()-1;
        int t = 0;
        while (index >= 0) {
            char c = S.charAt(index);
            index--;
            if (c == '-') {
                continue;
            } else {
//                System.out.println(t + " " + c);
                if (t == K) {
                    sb.append('-').append(convert(c));
                    t = 1;
                } else {
                    sb.append(convert(c));
                    t++;
                }
            }
        }
        return sb.reverse().toString();
    }

    private char convert(char c) {
        if (c >= 'a' && c <= 'z') {
            c = (char) (c - 32);
        }
        return c;
    }
}
