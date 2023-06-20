package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
    * @Title: Q66
    * @Description: https://leetcode-cn.com/problems/plus-one/
    * @author: libo
    * @date: 2020/9/8 14:34
    * @Version: 1.0
    */
@Slf4j
public class Q66 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q66().plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(new Q66().plusOne(new int[]{1,2,9})));
        System.out.println(Arrays.toString(new Q66().plusOne(new int[]{1,9,9})));
        System.out.println(Arrays.toString(new Q66().plusOne(new int[]{9,9})));
    }
    public int[] plusOne(int[] digits) {
        int p = 1;
        for(int j=digits.length-1;j>=0;j--){
            int t = digits[j]+p;
            if(t>9){
                t=t%10;
                p=1;
            }else{
                p=0;
            }
            digits[j]=t;
        }
        if(p==1){
            int[] res = new int[digits.length+1];
            System.arraycopy(digits, 0, res, 1,
                    Math.min(digits.length, res.length));
            res[0]=1;
            return res;
        }
        return digits;
    }
}
