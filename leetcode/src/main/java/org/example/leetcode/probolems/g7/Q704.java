package org.example.leetcode.probolems.g7;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q704
 * @Description: https://leetcode-cn.com/problems/binary-search/
 * @author: libo
 * @date: 2020/10/12 15:18
 * @Version: 1.0
 */
@Slf4j
public class Q704 {
    public static void main(String[] args) {
        System.out.println(new Q704().search(new int[]{-1,0,3,5,9,12},8));
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left+(right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}
