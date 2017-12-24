package cn.lee.hackerrank.tutorials.code30days.Day23_BST_Level_Order_Traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by jason on 17-12-24.
 */
public class Solution {
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }

    private static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        if (root != null) {
            // enqueue current root
            queue.offer(root);

            // while there are nodes to process
            while (queue != null && queue.size() > 0) {
                // dequeue next node
                Node tree = queue.poll();

                System.out.print(tree.data + " ");

                // enqueue child elements from next level in order
                if (tree.left != null){
                    queue.offer(tree.left);
                }
                if (tree.right != null){
                    queue.offer(tree.right);
                }
            }
        }
    }
}
