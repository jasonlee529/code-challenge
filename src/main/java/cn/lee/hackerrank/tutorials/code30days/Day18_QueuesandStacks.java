package cn.lee.hackerrank.tutorials.code30days;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


/**
 * Created by jason on 17-12-19.
 */
public class Day18_QueuesandStacks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Day18_QueuesandStacks p = new Day18_QueuesandStacks();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is "
                + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }

    Queue<Character> queues = new LinkedList<Character>();
    Stack<Character> stack = new Stack<Character>();

    private char dequeueCharacter() {
        return queues.poll();
    }

    private char popCharacter() {
        return stack.pop();
    }

    private void enqueueCharacter(char c) {
        queues.offer(c);
    }

    private void pushCharacter(char c) {
        stack.push(c);
    }
}
