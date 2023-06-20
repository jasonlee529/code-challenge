package cn.lee.leetcode.probolems.g5;

import cn.lee.leetcode.util.TreeNode;
import cn.lee.leetcode.util.TreeNodeFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q572
 * @Description: https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @author: libo
 * @date: 2020/10/12 14:37
 * @Version: 1.0
 */
@Slf4j
public class Q572 {
    public static void main(String[] args) {
        System.out.println(new Q572().isSubtree(TreeNodeFactory.build(new Integer[]{3, 4, 5, 1, null, 2}), TreeNodeFactory.build(new Integer[]{3, 1, 2})));
//        System.out.println(new Q572().isSubtree(TreeNodeFactory.build(new Integer[]{1, 1}), TreeNodeFactory.build(new Integer[]{1})));
//        System.out.println(new Q572().isSubtree(TreeNodeFactory.build(new Integer[]{3, 4, 5, 1, 2}), TreeNodeFactory.build(new Integer[]{4, 1, 2})));
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;   // t 为 null 一定都是 true
        if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            System.out.println(s + " " + t + " " + 24);
            return true;
        } else if (s != null && t != null) {
            if (s.val == t.val) {
                System.out.println(s + " " + t +" " + 29);
                if (isSubtree(s.left, t.left) && isSubtree(s.right, t.right)) {
                    System.out.println(s + " " + t +" " + 30);
                    return true;
                } else {
                    System.out.println(s + " " + t +" " + 33);
                    return isSubtree(s.left, t) || isSubtree(s.right, t);
                }
            } else {
                System.out.println(s + " " + t +" " + 37);
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        }
        System.out.println(s + " " + t +" " + 41);
        return false;
    }
}
