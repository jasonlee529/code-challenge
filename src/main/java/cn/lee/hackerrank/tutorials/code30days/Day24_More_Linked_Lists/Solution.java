package cn.lee.hackerrank.tutorials.code30days.Day24_More_Linked_Lists;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-linked-list-deletion/problem
 * <pre>
 *     Objective
 * Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * A Node class is provided for you in the editor. A Node object has an integer data field, , and a Node instance pointer, , pointing to another node (i.e.: the next node in a list).
 *
 * A removeDuplicates function is declared in your editor, which takes a pointer to the  node of a linked list as a parameter. Complete removeDuplicates so that it deletes any duplicate nodes from the list and returns the head of the updated list.
 *
 * Note: The  pointer may be null, indicating that the list is empty. Be sure to reset your  pointer when performing deletions to avoid breaking the list.
 *
 * Input Format
 *
 * You do not need to read any input from stdin. The following input is handled by the locked stub code and passed to the removeDuplicates function:
 * The first line contains an integer, , the number of nodes to be inserted.
 * The  subsequent lines each contain an integer describing the  value of a node being inserted at the list's tail.
 *
 * Constraints
 *
 * The data elements of the linked list argument will always be in non-decreasing order.
 * Output Format
 *
 * Your removeDuplicates function should return the head of the updated linked list. The locked stub code in your editor will print the returned list to stdout.
 *
 * Sample Input
 *
 * 6
 * 1
 * 2
 * 2
 * 3
 * 3
 * 4
 * Sample Output
 *
 * 1 2 3 4
 * Explanation
 *
 * , and our non-decreasing list is . The values  and  both occur twice in the list, so we remove the two duplicate nodes. We then return our updated (ascending) list, which is .
 * </pre>
 * Created by jason on 17-12-25.
 */
public class Solution {

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);

    }

    private static Node removeDuplicates(Node head) {
        Node h = head;
        while (h.next != null) {
            if (h.data == h.next.data) {
                h.next = h.next.next;
            } else {
                h = h.next;
            }
        }
        return head;
    }
}