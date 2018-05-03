package cn.lee.hackerrank.Data_Structrue.LinkedLists.Deleteduplicatevaluenodesfromasortedlinkedlist;

/**
 * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
 * <p>
 * You're given the pointer to the head node of a sorted linked list, where the data in the nodes is in ascending order. Delete as few nodes as possible so that the list does not contain any value more than once. The given head pointer may be null indicating that the list is empty.
 * <p>
 * For now do not be concerned with the memory deallocation. In common abstract data structure scenarios, deleting an element might also require deallocating the memory occupied by it. For an initial intro to the topic of dynamic memory please consult: http://www.cplusplus.com/doc/tutorial/dynamic/
 * <p>
 * Input Format
 * You have to complete the Node* RemoveDuplicates(Node* head) method which takes one argument - the head of the sorted linked list. You should NOT read any input from stdin/console.
 * <p>
 * Output Format
 * Delete as few nodes as possible to ensure that no two nodes have the same data. Adjust the next pointers to ensure that the remaining nodes form a single sorted linked list. Then return the head of the sorted updated linked list. Do NOT print anything to stdout/console.
 * <p>
 * Sample Input
 * <p>
 * 1 -> 1 -> 3 -> 3 -> 5 -> 6 -> NULL
 * NULL
 * Sample Output
 * <p>
 * 1 -> 3 -> 5 -> 6 -> NULL
 * NULL
 * Explanation
 * 1. 1 and 3 are repeated, and are deleted.
 * 2. Empty list remains empty.
 */
public class Solution {

    Node RemoveDuplicates(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node cur = head;
        while (cur.next != null) {
            Node next = cur.next;
            if (cur.data == next.data) {
                cur.next = next.next;
            } else {
                cur = next;
            }
        }
        return head;
    }
}

class Node {
    int data;
    Node next;
}