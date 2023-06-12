package org.example.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q292
 * @Description: https://leetcode-cn.com/problems/nim-game/
 * @author: libo
 * @date: 2020/9/22 9:32
 * @Version: 1.0
 */
@Slf4j
public class Q292 {
    public static void main(String[] args) {
        System.out.println(new Q292().canWinNim(1));
        System.out.println(new Q292().canWinNim(2));
        System.out.println(new Q292().canWinNim(3));
        System.out.println(new Q292().canWinNim(4));
        System.out.println(new Q292().canWinNim(5));
        System.out.println(new Q292().canWinNim(6));
        System.out.println(new Q292().canWinNim(7));
    }
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
