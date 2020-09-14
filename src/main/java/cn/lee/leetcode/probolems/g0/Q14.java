package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q14
 * @Description:
 * @author: libo
 * @date: 2020/9/7 16:05
 * @Version: 1.0
 */
@Slf4j
public class Q14 {
    public static void main(String[] args) {
        System.out.println(new Q14().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char c = '0';
        int index = 0;
        boolean isMax = true;
        while (isMax) {
            for (String str : strs) {
                if (str == null || str.equals("") || str.length() <= index) {
                    isMax = false;
                } else if (c == '0') {
                    c = str.charAt(index);
                }
                isMax = isMax && c == str.charAt(index);
            }
            if (isMax) {
                sb.append(c);
                index++;
                c = strs[0].charAt(index);
            }

        }
        return sb.toString();
    }
}
