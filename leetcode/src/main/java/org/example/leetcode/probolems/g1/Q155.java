package org.example.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title: Q155
 * @Description:
 * @author: libo
 * @date: 2020/9/15 11:43
 * @Version: 1.0
 */
@Slf4j
public class Q155 {
    class MinStack {

        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
