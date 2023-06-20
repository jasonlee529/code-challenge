package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
    * @Title: Q58
    * @Description: https://leetcode-cn.com/problems/length-of-last-word/
    * @author: libo
    * @date: 2020/9/8 13:50
    * @Version: 1.0
    */
@Slf4j
public class Q58 {
    public static void main(String[] args) {
        System.out.println(new Q58().lengthOfLastWord("hellow world "));
        System.out.println(new Q58().lengthOfLastWord("a"));
    }
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int len=0;
        int end=s.length()-1;
        int start=end;
        for(int i=end;i>=0;i--){
            if(s.charAt(i)==' '){
                break;
            }
            start --;
        }
        return end-start;
    }
}
