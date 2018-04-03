package cn.lee.hackerrank.Data_Structrue.Print_the_Elements_of_a_Linked_List;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
 */
public class Solution {

    void Print(Node head) {
        if (null != head) {
            System.out.println(head.data);
            Print(head.next);
        }
    }
}

class Node {
    int data;
    Node next;
}