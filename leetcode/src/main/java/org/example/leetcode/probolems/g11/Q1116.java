package org.example.leetcode.probolems.g11;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author libo
 * @Title: Q1116
 * @Description:
 * @date 2020/8/25 17:36
 * @Version 1.0
 */
@Slf4j
public class Q1116 {
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd foo = new ZeroEvenOdd(2);
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.zero(System.out::print);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.even(System.out::print);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.odd(System.out::print);
            }
        });
        t2.start();
        t3.start();
        t1.start();
    }
}

class ZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++){
            zero.acquire();
            printNumber.accept(0);
            if(i%2==1){
                odd.release();
            }else{
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

}