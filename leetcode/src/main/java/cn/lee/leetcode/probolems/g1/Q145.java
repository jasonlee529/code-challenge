package cn.lee.leetcode.probolems.g1;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Title: Q145
 * @Description: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author: libo
 * @date: 2020/9/29 9:35
 * @Version: 1.0
 */
@Slf4j
public class Q145 {
    public static void main(String[] args) {
        System.out.println(new Q145().postorderTraversal(TreeNodeFactory.build(new Integer[]{1,null,2,3})));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }

        }
        return res;
    }
}
