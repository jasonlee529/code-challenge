package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Title: Q232
 * @Description: https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @author: libo
 * @date: 2020/10/15 13:41
 * @Version: 1.0
 */
@Slf4j
public class Q232 {
    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inStack.push(x);
        }

        private void transfer() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (outStack.isEmpty()) {
                transfer();
            }
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (outStack.isEmpty()) {
                transfer();
            }
            return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }
}
