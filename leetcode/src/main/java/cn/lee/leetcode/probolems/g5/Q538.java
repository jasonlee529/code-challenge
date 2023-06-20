package cn.lee.leetcode.probolems.g5;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q538
    * @Description: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/
    * @author: libo
    * @date: 2020/9/21 9:49
    * @Version: 1.0
    */
@Slf4j
public class Q538 {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum+=root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
