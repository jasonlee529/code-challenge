package org.example.leetcode.probolems.g15;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q1539
 * @Description: https://leetcode-cn.com/problems/kth-missing-positive-number/
 * @author: libo
 * @date: 2020/9/23 16:05
 * @Version: 1.0
 */
@Slf4j
public class Q1539 {
    public static void main(String[] args) {
        System.out.println(new Q1539().findKthPositive(new int[]{2, 3, 4, 7, 11}, 1));
        System.out.println(new Q1539().findKthPositive(new int[]{2, 3, 4, 7, 11}, 2));
        System.out.println(new Q1539().findKthPositive(new int[]{2, 3, 4, 7, 11}, 3));
        System.out.println(new Q1539().findKthPositive(new int[]{2, 3, 4, 7, 11}, 4));
        System.out.println(new Q1539().findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(new Q1539().findKthPositive(new int[]{1,2, 3, 4, 7, 11}, 2));
    }

    public int findKthPositive(int[] arr, int k) {
        int cnt = 0;
        int left = 0;
        int cur = 1;
        while (cnt < k) {
            if (left < arr.length && arr[left] == cur) {
                left++;
            } else {
                cnt++;
            }
            cur++;
        }
        return cur-1;
    }
}
