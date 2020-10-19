package cn.lee.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @Title: Q844
 * @Description: https://leetcode-cn.com/problems/backspace-string-compare/
 * @author: libo
 * @date: 2020/10/19 11:36
 * @Version: 1.0
 */
@Slf4j
public class Q844 {
    public static void main(String[] args) {
        System.out.println(new Q844().backspaceCompare("ab#c", "ad#c"));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> st = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!ss.isEmpty()) {
                    ss.pop();
                }
            } else {
                ss.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(c);
            }
        }
        while (!ss.isEmpty() && !st.isEmpty()) {
            if (ss.pop() != st.pop()) {
                return false;
            }
        }
        return ss.isEmpty() && st.isEmpty();
    }
}
