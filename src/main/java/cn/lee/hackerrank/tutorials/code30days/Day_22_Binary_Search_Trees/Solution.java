package cn.lee.hackerrank.tutorials.code30days.Day_22_Binary_Search_Trees;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-binary-search-trees/problem
 * <p>
 * <pre>
 *     Objective
 * Today, we're working with Binary Search Trees (BSTs). Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * The height of a binary search tree is the number of edges between the tree's root and its furthest leaf. You are given a pointer, , pointing to the root of a binary search tree. Complete the getHeight function provided in your editor so that it returns the height of the binary search tree.
 *
 * Input Format
 *
 * The locked stub code in your editor reads the following inputs and assembles them into a binary search tree:
 * The first line contains an integer, , denoting the number of nodes in the tree.
 * Each of the  subsequent lines contains an integer, , denoting the value of an element that must be added to the BST.
 *
 * Output Format
 *
 * The locked stub code in your editor will print the integer returned by your getHeight function denoting the height of the BST.
 *
 * Sample Input
 *
 * 7
 * 3
 * 5
 * 2
 * 1
 * 4
 * 6
 * 7
 * Sample Output
 *
 * 3
 * Explanation
 *
 * The input forms the following BST:
 *
 * BST.png
 *
 * The longest root-to-leaf path is shown below:
 *
 * Longest RTL.png
 *
 * There are  nodes in this path that are connected by  edges, meaning our BST's . Thus, we print  as our answer.
 * </pre>
 * Created by jason on 17-12-23.
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
        int height = getHeight(root);
        System.out.println(height);
    }

    private static int getHeight(Node root) {
        return 0;
    }
}
