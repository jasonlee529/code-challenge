package cn.lee.hackerrank.Data_Structrue.LinkedLists.DeleteaNode;

/**
 * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
 * <p>
 * This challenge is part of a tutorial track by MyCodeSchool and is accompanied by a video lesson.
 * <p>
 * You’re given the pointer to the head node of a linked list and the position of a node to delete. Delete the node at the given position and return the head node. A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. The list may become empty after you delete the node.
 * <p>
 * Input Format
 * You have to complete the Node* Delete(Node* head, int position) method which takes two arguments - the head of the linked list and the position of the node to delete. You should NOT read any input from stdin/console. position will always be at least 0 and less than the number of the elements in the list.
 * <p>
 * Output Format
 * Delete the node at the given position and return the head of the updated linked list. Do NOT print anything to stdout/console.
 * <p>
 * Sample Input
 * <p>
 * 1 --> 2 --> 3 --> NULL, position = 0
 * 1 --> NULL , position = 0
 * <p>
 * Sample Output
 * <p>
 * 2 --> 3 --> NULL
 * NULL
 * Explanation
 * 1. 0th position is removed, 1 is deleted from the list.
 * 2. Again 0th position is deleted and we are left with empty list.
 */
public class Solution {
    Node Delete(Node head, int position) {
        // Complete this method
        if (position == 0) {
            head = head.next;
        } else {
            Node pre = head;
            for (int i = 0; i < position-1; i++) {
                pre = pre.next;
            }
            Node cur = pre.next;
            if (cur != null) {
                pre.next = cur.next;
            }
        }
        return head;

    }
}

class Node {
    int data;
    Node next;
}
