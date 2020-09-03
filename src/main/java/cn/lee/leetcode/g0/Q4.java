package cn.lee.leetcode.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q4
 * @Description: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author: libo
 * @date: 2020/9/3 21:50
 * @Version: 1.0
 */
@Slf4j
public class Q4 {
    public static void main(String[] args) {
        Q4 q = new Q4();
        System.out.println(q.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] arr = new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++){
            arr[i]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            arr[nums1.length+i]=nums2[i];
        }
        Arrays.sort(arr);
        double d = 0.0;
        if(arr.length%2==0){
            d=(arr[arr.length/2]+arr[arr.length/2-1])/2.0;
        }else{
            d=arr[arr.length-1/2];
        }
        return d;

    }
}