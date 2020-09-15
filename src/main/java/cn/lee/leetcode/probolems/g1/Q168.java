package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q168
 * @Description: https://leetcode-cn.com/problems/excel-sheet-column-title/
 * @author: libo
 * @date: 2020/9/15 22:52
 * @Version: 1.0
 */
@Slf4j
public class Q168 {

    public static void main(String[] args) {
        System.out.println(new Q168().convertToTitle(1));
        System.out.println(new Q168().convertToTitle(26));
        System.out.println(new Q168().convertToTitle(701));
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int t = (n - 1) % 26;
            sb.append(cases(t));
            n = (n-1) / 26;
        }
        return sb.reverse().toString();
    }

    private char cases(int t) {
        char base = 'A';
        return (char) ((int) base + t);
    }
}
