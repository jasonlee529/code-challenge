package cn.lee.leetcode.probolems.g6;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q617
 * @Description: https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @author: libo
 * @date: 2020/9/23 10:14
 * @Version: 1.0
 */
@Slf4j
public class Q617 {
    public static void main(String[] args) {
        TreeNode t1 = TreeNodeFactory.build(new Integer[]{1});
        TreeNode t2 = TreeNodeFactory.build(new Integer[]{2, null, 4, null, 7});
        t1 = new Q617().mergeTrees(t1, t2);
        System.out.println(t1.toString());
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            System.out.println(String.format("%s,%s", null, null));
            return null;
        } else if (t1 == null && t2 != null) {
            System.out.println(String.format("%s,%s", null, t2.val));
            t1 = new TreeNode(t2.val);
            t1.left = t2.left;
            t1.right = t2.right;
        } else if (t1 != null && t2 == null) {
            System.out.println(String.format("%s,%s", t1.val, null));
        } else if (t1 != null && t2 != null) {
            System.out.println(String.format("%d,%d", t1.val, t2.val));
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }
        return t1;
    }
}
