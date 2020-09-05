package cn.lee.leetcode.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q7
 * @Description: https://leetcode-cn.com/problems/reverse-integer/
 * @author: libo
 * @date: 2020/9/3 22:16
 * @Version: 1.0
 */
@Slf4j
public class Q7 {
    public static void main(String[] args) {
        Q7 q7 = new Q7();
        System.out.println(q7.reverse(-100));
    }

    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0)=='+'||s.charAt(0)=='-'){
            sb.append(s.charAt(0));
            for(int i=s.length()-1;i>=1;i--){
                sb.append(s.charAt(i));
            }
        }else{
            for(int i=s.length()-1;i>=0;i--){
                sb.append(s.charAt(i));
            }
        }
        int res = 0;
        if(sb.toString().compareTo(String.valueOf(Integer.MAX_VALUE))>0 ||sb.toString().compareTo(String.valueOf(Integer.MIN_VALUE))<0){
            return 0;
        }
        return Integer.valueOf(sb.toString());
    }
}
