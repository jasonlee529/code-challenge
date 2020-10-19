package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q340
 * @Description: https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @author: libo
 * @date: 2020/10/19 13:36
 * @Version: 1.0
 */
@Slf4j
public class Q340 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q340().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[Math.min(len1, len2)];
        int i1 = 0, i2 = 0, i = 0;
        while (i1 < len1 && i2 < len2) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else {
                arr[i] = nums1[i1];
                i++;
                i1++;
                i2++;
            }
        }
        return Arrays.copyOfRange(arr, 0, i);
    }
}
