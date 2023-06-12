package org.example.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q415
 * @Description: https://leetcode-cn.com/problems/add-strings/
 * @author: libo
 * @date: 2020/10/10 14:09
 * @Version: 1.0
 */
@Slf4j
public class Q415 {
    public static void main(String[] args) {
        System.out.println(new Q415().addStrings("1", "9"));
        System.out.println(new Q415().addStrings("11", "9"));
    }


    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int max = Math.max(l1, l2);
        num1 = zeroFill(num1, max);
        num2 = zeroFill(num2, max);
        int p = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = max - 1; i >= 0; i--) {
            int t1 = convert(num1.charAt(i));
            int t2 = convert(num2.charAt(i));
            int t = t1 + t2 + p;
            sb.append(t % 10);
            p = t / 10;
        }
        if (p == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    // 官方思路
    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    private int convert(char charAt) {
        switch (charAt) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
        }
        return 0;
    }

    private String zeroFill(String num1, int max) {
        String s = "";
        for (int i = 0; i < max - num1.length(); i++) {
            s += "0";
        }
        return s + num1;
    }
}
