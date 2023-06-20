package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

/**
    * @Title: Q35
    * @Description: https://leetcode-cn.com/problems/search-insert-position/
    * @author: libo
    * @date: 2020/9/7 20:07
    * @Version: 1.0
    */
@Slf4j
public class Q35 {
    public static void main(String[] args) {
        System.out.println(new Q35().searchInsert(new int[]{1,3,5,6},5));
        System.out.println(new Q35().searchInsert(new int[]{1,3,5,6},7));
    }
    public int searchInsert(int[] nums, int target) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                index=i;
                break;
            }
            index++;
        }
        return index;
    }
}
