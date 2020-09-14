package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q344
 * @Description: https://leetcode-cn.com/problems/reverse-string/
 * @author: libo
 * @date: 2020/9/11 10:04
 * @Version: 1.0
 */
@Slf4j
public class Q344 {

    public static void main(String[] args) {
        char [] a =  "ABC".toCharArray();
        new Q344().reverseString(a);
        System.out.println(Arrays.toString(a));
    }
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char t = s[left];
            s[left]=s[right];
            s[right]=t;
            left++;
            right--;
        }
    }
}
