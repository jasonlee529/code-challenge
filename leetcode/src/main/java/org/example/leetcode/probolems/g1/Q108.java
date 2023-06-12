package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q108
 * @Description:
 * @author: libo
 * @date: 2020/9/10 10:25
 * @Version: 1.0
 */
@Slf4j
public class Q108 {
    public static void main(String[] args) {
        System.out.println(new Q108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
       return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }
        int mid =(left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=helper(nums,left,mid-1);
        node.right=helper(nums,mid+1,right);
        return node;
    }
}
