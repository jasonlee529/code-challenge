package org.example.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q106
 * @Description: https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author: libo
 * @date: 2020/9/25 9:25
 * @Version: 1.0
 */
@Slf4j
public class Q106 {
    //    中序遍历 inorder = [9,3,15,20,7]
//    后序遍历 postorder = [9,15,7,20,3]
    public static void main(String[] args) {
        TreeNode node = new Q106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(node.val);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length <= 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(rootVal);
        int index = findIndex(inorder, rootVal);
        int[] leftInorder = new int[index];
        int[] leftPostorder = new int[index];
        int[] rightInorder = new int[inorder.length - index - 1];
        int[] rightPostorder = new int[inorder.length - index - 1];
        System.arraycopy(inorder, 0, leftInorder, 0, leftInorder.length);
        System.arraycopy(inorder, index + 1, rightInorder, 0, rightInorder.length);
        System.arraycopy(postorder, 0, leftPostorder, 0, leftPostorder.length);
        System.arraycopy(postorder, index, rightPostorder, 0, rightPostorder.length);
        node.left = buildTree(leftInorder, leftPostorder);
        node.right = buildTree(rightInorder, rightPostorder);
        return node;
    }

    private int findIndex(int[] inorder, int rootVal) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return inorder.length - 1;
    }
}
