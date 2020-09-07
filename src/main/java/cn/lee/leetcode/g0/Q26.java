package cn.lee.leetcode.g0;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q26
 * @Description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author: libo
 * @date: 2020/9/7 19:09
 * @Version: 1.0
 */
@Slf4j
public class Q26 {
    public static void main(String[] args) {
        System.out.println(new Q26().removeDuplicates(new int[]{}));
        System.out.println(new Q26().removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(new Q26().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int index = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                nums[index] = nums[i];
                pre=nums[i];
                index++;
            }
        }
        return index;
    }
}
