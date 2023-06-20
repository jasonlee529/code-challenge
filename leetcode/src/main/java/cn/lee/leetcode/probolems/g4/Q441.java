package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q441
 * @Description: https://leetcode-cn.com/problems/arranging-coins/
 * @author: libo
 * @date: 2020/9/27 11:55
 * @Version: 1.0
 */
@Slf4j
public class Q441 {
    public static void main(String[] args) {
      for(int i=1;i<10;i++){
          System.out.println(i+"  "+new Q441().arrangeCoins(i));
      }
    }
    public int arrangeCoins(int n) {
        int l = 0;
        while (n >= 0) {
            l++;
            n = n - l;
        }
        return l-1;
    }
}
