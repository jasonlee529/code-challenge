package cn.lee.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q551
 * @Description: https://leetcode-cn.com/problems/student-attendance-record-i/
 * @author: libo
 * @date: 2020/9/30 17:51
 * @Version: 1.0
 */
@Slf4j
public class Q551 {
    public static void main(String[] args) {
        System.out.println(new Q551().checkRecord("PPALLL"));
        System.out.println(new Q551().checkRecord("PPALLP"));
    }
    public boolean checkRecord(String s) {
        int aCnt = 0;
        int lCnt = 0;
        boolean isOk = true;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                aCnt += 1;
            }
            if (c == 'L') {
                lCnt++;
            } else {
                lCnt = 0;
            }
            isOk = isOk && lCnt <= 2 && aCnt <= 1;
        }
        return isOk;
    }
}
