package cn.lee.newcoder.hw.y2022;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @Title: Q3
 * @Description:
 * @author: libo
 * @date: 2022/3/6 0006 23:27
 * @Version: 1.0
 */
@Slf4j
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digits = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        calculate(digits, s1, s2);
    }

    private static void calculate(int digits, String s1, String s2) {
        Long n1 = to10(s1, digits);
        Long n2 = to10(s2, digits);
        if (n1 == null || n2 == null) {
            System.out.println(-1);
            return;
        }
        Long ans = n1 - n2;
        if (ans < 0) {
            System.out.print(1);
            print(ans,digits,false);
        } else {
            System.out.print(0);
            print(ans,digits,true);
        }
    }

    private static void print(Long data, int digits, boolean b) {
        String ans="";
        if(!b){
           data=-data;
        }
        while(data>0){
            Long mod=data%digits;
            if(mod<=9){
                ans=mod+ans;
            }else{
                ans=(char)(mod-9+'a')+ans;
            }
            data=data/digits;
        }
        if(!b){
            ans="-"+ans;
        }
        System.out.println(" "+ans);
    }


    /**
     * 原始数字转为10进制
     */
    private static Long to10(String s1, int digits) {
        if (s1.startsWith("0")) {
            return null;
        }
        Long ans=0L,base=1L;
        for (int i = s1.length() - 1; i >= 0; i--) {
            char c=s1.charAt(i);
            int t=0;
            if(c>='0'&&c<='9'){
                t=c-'0';
            }
            if(c>='a'&&c<='z'){
                t=c-'a'+digits;
            }
            ans+=t*base;
            base=base*digits;
        }
        return ans;
    }

    @Test
    public void test_1(){
        calculate(2,"11","1");
    }
    @Test
    public void test_2(){
        calculate(8,"01","1");
    }
}