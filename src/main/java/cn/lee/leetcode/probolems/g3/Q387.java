package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

/**
    * @Title: Q387
    * @Description: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
    * @author: libo
    * @date: 2020/9/11 17:53
    * @Version: 1.0
    */
@Slf4j
public class Q387 {
    public static void main(String[] args) {
        System.out.println(new Q387().firstUniqChar("cc"));
        System.out.println(new Q387().firstUniqChar("leetcode"));
        System.out.println(new Q387().firstUniqChar("loveleetcode"));
    }
    public int firstUniqChar(String s) {
        int left =0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right=s.length()-1;
            }else{
                right--;
            }
        }
        return left>=s.length()?-1:left;
    }
}
