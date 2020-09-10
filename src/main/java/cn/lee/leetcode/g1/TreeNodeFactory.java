package cn.lee.leetcode.g1;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title: TreeNodeFactory
 * @Description:
 * @author: libo
 * @date: 2020/9/10 15:44
 * @Version: 1.0
 */
@Slf4j
public class TreeNodeFactory {
    public static void main(String[] args) {
        TreeNode h = build(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        System.out.println(h.val);
    }
    public static TreeNode build(Integer[] arr) {
        TreeNode head = null;
        if (arr.length == 0) {
            return head;
        }
        Deque<TreeNode> nodes = new LinkedList<>();
        head = new TreeNode(arr[0]);
        nodes.add(head);
        int len=arr.length;
        for (int i = 1; i < len; i+=2) {
            TreeNode p = nodes.pop();
            if(arr[i]==null){
                p.left=null;
            }else{
                p.left=new TreeNode(arr[i]);
                nodes.add(p.left);
            }
            if(i+1<len){
                if(arr[i+1]==null){
                    p.right=null;
                }else{
                    p.right=new TreeNode(arr[i+1]);
                    nodes.add(p.right);
                }
            }
        }
        return head;
    }
}
