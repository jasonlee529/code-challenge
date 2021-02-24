package cn.lee.interview._2020;

import cn.lee.leetcode.util.ListNode;
import cn.lee.leetcode.util.ListNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @Title: Didi
 * @Description:
 * @author: libo
 * @date: 2021/1/6 20:39
 * @Version: 1.0
 */
@Slf4j
public class Didi {

    @Test
    public void test1() {
        Assert.assertEquals(ListNodeFactory.build(new int[]{3, 2, 1}).toString(), reverse(ListNodeFactory.build(new int[]{1, 2, 3})).toString());
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        while (head.next != null) {
            ListNode tmp = head.next;
            tmp.next = head;
            head.next = head.next.next;
        }
        return head;
    }

    //a b a b
    @Test
    public void test2() {
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(1);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        s2.acquire();
                        System.out.println("A");
                        s1.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        s1.acquire();
                        System.out.println("B");
                        s2.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
//class ListNode {
//    public int val;
//    publicListNode next;
//
//    public ListNode(int x) {
//        val = x;
//    }
//
//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                (next != null ? ", next=" + next.toString() : ", next= null" )+
//                '}';
//    }
//}
