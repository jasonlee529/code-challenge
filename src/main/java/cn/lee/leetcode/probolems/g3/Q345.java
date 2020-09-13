package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q345
 * @Description: https://leetcode-cn.com/problems/reverse-vowels-of-a-string/  a[ei]、e[i:]、i[ ai]、o[eu]、u[ju:]
 * @author: libo
 * @date: 2020/9/11 14:44
 * @Version: 1.0
 */
@Slf4j
public class Q345 {
    public static void main(String[] args) {
        System.out.println(new Q345().reverseVowels("hello"));
    }
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char [] chars = s.toCharArray();
        while (left < right) {
            char c1 = chars[left];
            char c2 = chars[right];
            if (!isAU(c1)){
                left++;
                continue;
            }
            if(!isAU(c2)){
                right--;
                continue;
            }
            char c=c1;
            chars[left]=c2;
            chars[right]=c;
            left++;
            right--;
        }
        s = new String(chars);
        return s;
    }

    private boolean isAU(char c1) {
        return c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u' ||
                c1 == 'A' || c1 == 'E' || c1 == 'I' || c1 == 'O' || c1 == 'U';
    }
}
