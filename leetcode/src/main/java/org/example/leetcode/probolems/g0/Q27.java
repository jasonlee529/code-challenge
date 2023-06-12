package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q27
 * @Description: https://leetcode-cn.com/problems/remove-element/
 * @author: libo
 * @date: 2020/9/7 19:38
 * @Version: 1.0
 */
@Slf4j
public class Q27 {
    public static void main(String[] args) {
        System.out.println(new Q27().removeElement(new int[]{3,2,2,3},3));
    }
    public int removeElement(int[] nums, int val) {
        int index=0;
        for(int i:nums){
            if(i!=val){
                nums[index]=i;
                index++;
            }
        }
        return index;
    }
}
