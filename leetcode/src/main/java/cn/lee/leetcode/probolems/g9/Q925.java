package cn.lee.leetcode.probolems.g9;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q925
 * @Description: https://leetcode-cn.com/problems/long-pressed-name/
 * @author: libo
 * @date: 2020/10/21 9:52
 * @Version: 1.0
 */
@Slf4j
public class Q925 {
    public static void main(String[] args) {
        System.out.println(new Q925().isLongPressedName("alex", "aaleex"));
        System.out.println(new Q925().isLongPressedName("saeed", "ssaaedd"));
        System.out.println(new Q925().isLongPressedName("leelee", "lleeelee"));
    }

    public boolean isLongPressedName(String name, String typed) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < name.length() && index2 < typed.length()) {
            int l1 = findSize(name, index1);
            int l2 = findSize(typed, index2);
            if (name.charAt(index1) == typed.charAt(index2) && l1 <= l2) {
                index1 += l1;
                index2 += l2;
            } else {
                return false;
            }
        }
        return index1 == name.length() && index2==typed.length();

    }

    private int findSize(String arr, int index) {
        char c = arr.charAt(index);
        int cnt = 1;
        for (int i = index + 1; i < arr.length(); i++) {
            if (c == arr.charAt(i)) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
