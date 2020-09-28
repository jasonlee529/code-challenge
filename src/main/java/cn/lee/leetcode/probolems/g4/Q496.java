package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q496
 * @Description: https://leetcode-cn.com/problems/next-greater-element-i/
 * @author: libo
 * @date: 2020/9/28 9:22
 * @Version: 1.0
 */
@Slf4j
public class Q496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = findNext(nums1[i], nums2);
        }
        return arr;
    }

    private int findNext(int n, int[] nums2) {
        int index = nums2.length;
        for (int i = 0; i < nums2.length; i++) {
            if (n == nums2[i]) {
                index = i;
            }
            if(i>index&&nums2[i]>n){
                return nums2[i];
            }
        }
        return -1;
    }
}
