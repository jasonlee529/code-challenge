package cn.lee.leetcode.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Title: Q20
 * @Description:
 * @author: libo
 * @date: 2020/9/7 16:35
 * @Version: 1.0
 */
@Slf4j
public class Q20 {
    public static void main(String[] args) {
//        System.out.println(new Q20().isValid("()"));
//        System.out.println(new Q20().isValid("(]"));
//        System.out.println(new Q20().isValid("()[]{}"));
        System.out.println(new Q20().isValid("([)]"));
    }

    public boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        queue.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c2=s.charAt(i);
            if(queue.isEmpty()){
                queue.add(c2);
                continue;
            }
            char c1 = queue.peekLast();
            if(isPair(c1,c2)){
                queue. pollLast();
            }else{
                queue.add(c2);
            }
        }
        return queue.isEmpty();
    }

    public boolean isValid2(String s) {
        boolean isT = true;
        int l = s.length();
        for (int i = 0; i < (l + 1) / 2; i++) {
            isT = isT && isPair(s.charAt(i), s.charAt(l - i - 1));
        }
        return isT;
    }

    private boolean isPair(char c1, char c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        } else if (c1 == '[' && c2 == ']') {
            return true;
        } else if (c1 == '{' && c2 == '}') {
            return true;
        }
        return false;
    }
}
