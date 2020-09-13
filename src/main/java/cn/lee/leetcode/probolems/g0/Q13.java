package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q13
 * @Description: https://leetcode-cn.com/problems/roman-to-integer/
 * @author: libo
 * @date: 2020/9/4 14:01
 * @Version: 1.0
 */
@Slf4j
public class Q13 {
    public static void main(String[] args) {
        Q13 q = new Q13();
        System.out.println(q.romanToInt("I"));
        System.out.println(q.romanToInt("XXVII"));

    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = convert(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = convert(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum+=preNum;
        return sum;
    }

    public int convert(char c) {
        int r = 0;
        switch (c) {
            case 'I':
                r = 1;
                break;
            case 'V':
                r = 5;
                break;
            case 'X':
                r = 10;
                break;
            case 'L':
                r = 50;
                break;
            case 'C':
                r = 100;
                break;
            case 'D':
                r = 500;
                break;
            case 'M':
                r = 1000;
                break;
            default:
                r = 0;
                break;
        }
        return r;
    }

}
