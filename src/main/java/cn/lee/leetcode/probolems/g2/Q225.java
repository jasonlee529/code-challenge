package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title: Q225
 * @Description: https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @author: libo
 * @date: 2020/10/15 11:06
 * @Version: 1.0
 */
@Slf4j
public class Q225 {
    class MyStack {

        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
            for (int i = queue.size() - 1; i > 0; i--) {
                queue.offer(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

