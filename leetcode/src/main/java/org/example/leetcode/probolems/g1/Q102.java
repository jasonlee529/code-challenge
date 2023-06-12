package org.example.leetcode.probolems.g1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.DelayQueue;

import cn.lee.leetcode.util.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q102
    * @Description: 
    * @author: libo
    * @date: 2022/3/8 16:28
    * @Version: 1.0
    */
@Slf4j
public class Q102 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null){
			return new ArrayList();
		}
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList();
		Deque<TreeNode> second =new LinkedList<>();
		deque.push(root);
		List<Integer> line = new ArrayList<>();
		while(!deque.isEmpty()){
			TreeNode node = deque.poll();
			line.add(node.val);
			if(node.left!=null){
				second.offer(node.left);
			}
			if(node.right!=null){
				second.offer(node.right);
			}
			if(deque.isEmpty()){
				deque=second;
				second=new LinkedList<>();
				res.add(line);
				line=new ArrayList<>();
			}
		}
		if(!line.isEmpty()){
			res.add(line);
		}

		return res;
	}
}
