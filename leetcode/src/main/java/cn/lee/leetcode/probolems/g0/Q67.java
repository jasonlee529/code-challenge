package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q67
 * @Description: https://leetcode-cn.com/problems/add-binary/
 * @author: libo
 * @date: 2020/9/8 15:27
 * @Version: 1.0
 */
@Slf4j
public class Q67 {
    public static void main(String[] args) {
        System.out.println(new Q67().addBinary("1", "0"));
        System.out.println(new Q67().addBinary("1", "1"));
        System.out.println(new Q67().addBinary("1", "11"));
        System.out.println(new Q67().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        String res = "";
        int p = 0;
        while (l1 >= 0 || l2 >= 0) {
            int t1 = 0;
            int t2 = 0;
            if (l1 >= 0) {
                t1 = Integer.valueOf(a.substring(l1, l1 + 1));
                l1--;
            }
            if (l2 >= 0) {
                t2 = Integer.valueOf(b.substring(l2, l2 + 1));
                l2--;
            }
            int t = t1 + t2 + p;
            res = t % 2 + res;
            p = t / 2;
        }
        if (p == 1) {
            res = "1" + res;
        }
        return res;
    }
}
