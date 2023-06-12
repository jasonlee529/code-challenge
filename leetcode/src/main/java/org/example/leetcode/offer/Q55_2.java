package org.example.leetcode.offer;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q55_2
    * @Description: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
    * @author: libo
    * @date: 2020/9/23 13:52
    * @Version: 1.0
    */
@Slf4j
public class Q55_2 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int l1 = len(root.left);
        int l2 = len(root.right);
        return isBalanced(root.left)&& isBalanced(root.right) && (Math.abs(l1 - l2) <= 1);
    }

    private int len(TreeNode node) {
        if(node ==null){
            return 0;
        }else if (node.left == null && node.right == null) {
            return 1;
        } else {
            int l1 = len(node.left);
            int l2 = len(node.right);
            return Math.max(l1, l2)+1;
        }
    }
}
