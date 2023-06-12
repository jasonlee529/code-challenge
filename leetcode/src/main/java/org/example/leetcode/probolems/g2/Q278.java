package org.example.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q278
 * @Description: https://leetcode-cn.com/problems/first-bad-version/
 * @author: libo
 * @date: 2020/9/25 13:36
 * @Version: 1.0
 */
@Slf4j
public abstract class Q278 {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    abstract boolean isBadVersion(int version);
}
