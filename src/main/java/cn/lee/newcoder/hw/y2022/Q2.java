package cn.lee.newcoder.hw.y2022;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Title: Q2
 * @Description:
 * @author: libo
 * @date: 2022/3/6 0006 23:09
 * @Version: 1.0
 */
@Slf4j
public class Q2 {
    static char dest = 'o';
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = input.length();
        String input2 = input + input;
        for (int win = len; win > 0; win--) {
            PriorityQueue<Integer> res=new PriorityQueue<>();
            for (int i = 0; i < len; i++) {
               int num=calo(input2,i,i+win-1);
               if(num%2==0){
                   res.add(win);
               }
            }
            if(!res.isEmpty()){
                int ans=res.poll();
                System.out.println(ans);
                return;
            }
        }
        System.out.println(0);
    }

    private static int calo(String input2, int start, int end) {
        int ans=0;
        for(int i=start;i<=end;i++){
            if(input2.charAt(i)==dest){
                ans++;
            }
        }
        return ans;
    }
}