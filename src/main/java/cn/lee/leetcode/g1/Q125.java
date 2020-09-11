package cn.lee.leetcode.g1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q125
 * @Description: https://leetcode-cn.com/problems/valid-palindrome/
 * @author: libo
 * @date: 2020/9/10 17:50
 * @Version: 1.0
 */
@Slf4j
public class Q125 {
    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'A');
        System.out.println((int) '0');
        System.out.println((int) 'P');
//        System.out.println(new Q125().isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(new Q125().isPalindrome("OP"));
        System.out.println(new Q125().isPalindrome("0P"));
        System.out.println(new Q125().isPalindrome(",; W;:GlG:;l ;,"));
    }

    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        boolean pali = true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (!isLegal(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isLegal(s.charAt(right))) {
                right--;
                continue;
            }
            left++;
            right--;
            pali = pali && (isCharacter(c1) && isCharacter(c2) ? (c1 == c2 || Math.abs((int) c1 - (int) c2) == 32) : c1 == c2);
        }
        return pali;
    }

    private boolean isCharacter(char c) {
        return (c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z');
    }

    private boolean isLegal(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z');
    }
}
