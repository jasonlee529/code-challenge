package cn.lee.leetcode.g1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q110
 * @Description: https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author: libo
 * @date: 2020/9/10 13:48
 * @Version: 1.0
 */
@Slf4j
public class Q110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.left.left=new TreeNode(4);
        root.left.left.right=new TreeNode(4);
        root.left.right=new TreeNode(3);
        root.right=new TreeNode(2);
        System.out.println(new Q110().isBalanced(root));
        root = new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(3);
        System.out.println(new Q110().isBalanced(root));
    }
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
