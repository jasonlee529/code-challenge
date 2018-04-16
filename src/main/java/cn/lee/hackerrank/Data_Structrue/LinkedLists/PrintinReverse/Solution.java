package cn.lee.hackerrank.Data_Structrue.LinkedLists.PrintinReverse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
 * This challenge is part of a tutorial track by MyCodeSchool and is accompanied by a video lesson.
 * <p>
 * You are given the pointer to the head node of a linked list and you need to print all its elements in reverse order from tail to head, one element per line. The head pointer may be null meaning that the list is empty - in that case, do not print anything!
 * <p>
 * Input Format
 * You have to complete the void ReversePrint(Node* head) method which takes one argument - the head of the linked list. You should NOT read any input from stdin/console.
 * <p>
 * Output Format
 * Print the elements of the linked list in reverse order to stdout/console (using printf or cout) , one per line.
 * <p>
 * Sample Input
 * <p>
 * 1 --> 2 --> NULL
 * 2 --> 1 --> 4 --> 5 --> NULL
 * <p>
 * Sample Output
 * <p>
 * 2
 * 1
 * 5
 * 4
 * 1
 * 2
 * Explanation
 * 1. First list is printed from tail to head hence 2,1
 * 2. Similarly second list is also printed from tail to head.
 */
public class Solution {


    void ReversePrint(Node head) {
        Stack<Integer> datas = new Stack<Integer>();
        while (head !=null){
            datas.push(head.data);
            head = head.next;
        }
        while (!datas.isEmpty()){
            System.out.println(datas.pop());
        }
    }
}

class Node {
    int data;
    Node next;
}