package org.example.leetcode.lcp;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q17
 * @Description: https://leetcode-cn.com/problems/nGK0Fy/
 * @author: libo
 * @date: 2020/9/17 18:12
 * @Version: 1.0
 */
@Slf4j
public class Q17 {
    public static void main(String[] args) {
        System.out.println(new Q17().calculate("AB"));
    }
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                x = A(x, y);
            } else {
                y = B(x, y);
            }
        }
        return x + y;
    }

    private int B(int x, int y) {
        return 2 * y + x;
    }

    private int A(int x, int y) {
        return 2 * x + y;
    }
}
